package src.ru.croc.task2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //начальный аргумент
        int a = scanner.nextInt();

        //разность арифметической прогрессии
        int b = scanner.nextInt();

        //кол-во членов погрессии
        int c = scanner.nextInt();

        //сумма ряда
        int sum = 0;

        for(int i = 0; i < c; i++){
            sum = sum + a;
            a = a + b;
        }
        System.out.println("Sum: " + sum);

    }
}
