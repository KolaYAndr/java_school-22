package ru.croc.task16;

import ru.croc.task16.classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Customer customer = initCustomer(scanner);

        System.out.println("Input customer's info");
        System.out.println("Format: latitude, longitude");
        String coordinates = scanner.nextLine();
        System.out.println("Input customer's addition wishes");
        String wishes = scanner.nextLine();
        Coordinate coord = new Coordinate(coordinates);
        Customer customer = new Customer(coord, ComfortClass.USUAL, wishes);

        Driver d1 = new Driver("Snezhana Denisovna", new Coordinate(60.9386, 31.3141), ComfortClass.COMFORT, "детское кресло");
        Driver d2 = new Driver("Ivanov Ivan", new Coordinate(59.9486, 30.324), ComfortClass.COMFORT, "детское кресло");
        Driver d3 = new Driver("Petrov Petr ", new Coordinate(59.9486, 25.314), ComfortClass.COMFORT, "детское кресло");

        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);


        //ArrayList<Driver> drivers = initDrivers();

        Finder finder = new Finder(customer, drivers);
        finder.getClosestFitting();
    }

    private static ArrayList<Driver> initDrivers() {
        Driver d1 = new Driver("Snezhana Denisovna", new Coordinate(60.9386, 31.3141), ComfortClass.COMFORT, "детское кресло");
        Driver d2 = new Driver("Ivanov Ivan", new Coordinate(59.9486, 10.324), ComfortClass.COMFORT, "детское кресло");
        Driver d3 = new Driver("Petrov Petr ", new Coordinate(59.9486, 15.314), ComfortClass.COMFORT, "детское кресло");

        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);

        return drivers;
    }

    private static Customer initCustomer(Scanner scanner) {
        System.out.println("Input customer's info");
        System.out.println("Format: latitude, longitude");
        String coordinates = scanner.nextLine();
        System.out.println("Input customer's addition wishes");
        String wishes = scanner.nextLine();
        Coordinate coord = new Coordinate(coordinates);
        return new Customer(coord, ComfortClass.USUAL, wishes);
    }
}
