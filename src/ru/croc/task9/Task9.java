package ru.croc.task9;

import ru.croc.task9.classes.Runner;

public class Task9 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner("aaaaaaa"));
        Thread t2 = new Thread(new Runner("fffffff"));
        Thread t3 = new Thread(new Runner("mmmmmmm"));
        Thread t4 = new Thread(new Runner("ttttttt"));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
