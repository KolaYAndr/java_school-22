package ru.croc.task9.classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Runner implements Runnable {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final String hashCode = "40682260CC011947FC2D0B1A927138C5";
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
        System.out.println(searching());
    }

    private String searching() {
        char[] startCharedPassword = charPassword.clone();

        for (int i = charPassword.length - 1; i >= 0; i--) {

            char j = (char) (charPassword[i] + 1);
            while (j != startCharedPassword[i]) {
                password = charPassword.toString();

                //проверяем совпадение
                if ((hashPassword(password).equals(hashCode.toUpperCase()))) {
                    return password; // выход из цикла
                }

                charPassword[i] = j;
                if (j == 122) j = 96;
                j++;
        }
    }
        return null;
    }
}