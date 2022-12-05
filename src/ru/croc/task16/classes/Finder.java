package ru.croc.task16.classes;

import java.util.List;
import java.util.TreeSet;

public class Finder {
    private Customer customer;
    private final TreeSet<Driver> driversTreeSet = new TreeSet<>((d1, d2) ->
            d1.coordinate.calculateDistanceTo(customer.getCoordinate()) - d2.coordinate.calculateDistanceTo(customer.getCoordinate()));

    public Finder(Customer customer, List<Driver> drivers) {
        this.customer = customer;
        driversTreeSet.addAll(drivers);
    }

    public Driver getClosestFitting() {
        for (Driver driver : driversTreeSet) {
            if (driver.matchesConditions(customer)) {
                System.out.println(driver + " is the best choice!");
                return driver;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "For " + customer + "best choice is " + driversTreeSet.first();
    }
}
