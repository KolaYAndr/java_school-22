package ru.croc.task16.classes;

import java.util.List;

public class Helper {

    public ComfortClass extractComfortClass(String arg0) {
        return ComfortClass.getClass(Integer.parseInt(arg0));
    }

    public Coordinate extractCoordinate(String arg1, String arg2) {
        return new Coordinate(arg1 + ", " + arg2);
    }

    public String[] extractAdditions(String[] args) {
        StringBuilder result = new StringBuilder();

        for (int i = 3; i < args.length; i++) {
            result.append(args[i]).append(" ");
        }

        return result.toString().split(" ");
    }

    public void findAndOutput(Customer customer, List<Driver> drivers) {
        Finder finder = new Finder(customer, drivers);
        Driver driver = finder.getClosestFitting();
        if (driver != null) {
            System.out.println(driver + " is the best choice");
        } else {
            System.out.println("No matching drivers");
        }
    }
}
