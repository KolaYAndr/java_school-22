package ru.croc.task11;

import ru.croc.task11.classes.Client;

public class Task11 {
    public static final int PORT = 2021;
    public static String ipAddr = "localhost";

    public static void main(String[] args) {
        new Client(ipAddr, PORT);
    }
}
