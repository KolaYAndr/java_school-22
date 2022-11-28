package ru.croc.task9;

import ru.croc.task9.classes.ThreadManager;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Какое количество потоков?");
        int threadsAmount = scanner.nextInt();

        System.out.println("Введите хэш пароля");
        String hash = scanner.next();

        System.out.println("Какой длины был пароль?");
        int length = scanner.nextInt();

        ThreadManager tm = new ThreadManager(threadsAmount, hash.toUpperCase(), length);
    }
}
