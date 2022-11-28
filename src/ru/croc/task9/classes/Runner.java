package ru.croc.task9.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

public class Runner implements Runnable {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    //private static final String hashCode = "40682260CC011947FC2D0B1A927138C5"; //начальный хэш
    private final String hashCode;
    private String password;
    private String endPoint;
    private char[] charPassword;

    public Runner(String entryPoint, String endPoint, String hashCode) {
        this.password = entryPoint;
        this.charPassword = entryPoint.toCharArray();
        this.endPoint = endPoint;
        this.hashCode = hashCode;
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
        while (!Objects.equals(password, endPoint)) {
            String hash = hashPassword(password);
            boolean equals = hash.equals(hashCode);
            if (equals) {
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
            password = String.copyValueOf(charPassword);
            passwordInt[last]++;
        }
        return null;
    }
}