package ru.croc.task9.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Runner implements Runnable {
    private static volatile boolean found = false;
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    //private static final String hashCode = "40682260CC011947FC2D0B1A927138C5"; //начальный хэш
    private static final String hashCode = "7f0a8265f16d8141ea97020e218219a4".toUpperCase(); //msv хэш сгенерировал через сайт https://emn178.github.io/online-tools/md5.html
    private String password;
    private char[] charPassword;

    public Runner(String str) {
        this.password = str;
        this.charPassword = str.toCharArray();
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }


    @Override
    public void run() {
        String result = searching();
        if(result != null) System.out.println(result);
    }

    private String searching() {
        int[] passwordInt = new int[charPassword.length];
        for (int i = 0; i < charPassword.length; i++) {
            passwordInt[i] = charPassword[i];
        }

        int last = passwordInt.length - 1;

        //цикл смены пароля
        while (!found) {
            String hash = hashPassword(password);
            boolean equals = hash.equals(hashCode);
            if (equals) {
                found = true;
                return password;// выход из цикла
            }

            for (int i = last; i >= 0; i--) {
                if (passwordInt[i] > 122 & i > 0) {
                    passwordInt[i] = 97;
                    passwordInt[i - 1]++;
                }
                if (passwordInt[0] > 122) passwordInt[0] = 97;
                charPassword[i] = (char) passwordInt[i];
            }
            password = Arrays.toString(charPassword);
            System.out.println(charPassword);
            passwordInt[last]++;
        }
        return null;
    }
}