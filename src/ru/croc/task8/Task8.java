package ru.croc.task8;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter country: ");
        String country = scanner.next();
        System.out.print("Enter language code: ");
        String language = scanner.next();
        System.out.print("Enter a double: ");
        try {
            Double prize = scanner.nextDouble();
            if (country != null & language != null) {
                Locale locale = new Locale(language, country);
                NumberFormat format = NumberFormat.getCurrencyInstance(locale);
                System.out.println("Result: " + format.format(prize));
            } else {
                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
                System.out.println("Result: " + format.format(prize));
            }
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage() + " invalid number");
        }

    }
}