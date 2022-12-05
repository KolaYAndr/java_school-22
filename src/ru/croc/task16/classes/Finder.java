package ru.croc.task16.classes;

import java.util.Iterator;
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
        Iterator<Driver> iterator = driversTreeSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().matchesConditions(customer)) {
                return iterator.next();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "For " + customer + "best choice is " + driversTreeSet.first();
    }
}
