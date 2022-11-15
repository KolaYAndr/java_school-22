package ru.croc.task8;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a double: ");
        try {
            Double prize = scanner.nextDouble();
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("Result: " + format.format(prize));
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage() + " invalid number");
        }

    }
}