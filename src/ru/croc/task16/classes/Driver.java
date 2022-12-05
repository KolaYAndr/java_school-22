package ru.croc.task16.classes;

public class Driver {
    public String name;
    public final Coordinate coordinate;
    private ComfortClass comfortClass;
    private String additions;

    public Driver(String name, Coordinate coordinate, ComfortClass comfortClass, String additions) {
        this.name = name;
        this.coordinate = coordinate;
        this.comfortClass = comfortClass;
        this.additions = additions;
    }

    public boolean matchesConditions(Customer customer) {
        String customerAdditions = customer.getAdditions();
        if (customerAdditions.equals("")) return this.comfortClass == customer.getComfortClass() & additions.equalsIgnoreCase(customerAdditions);
        else return this.comfortClass == customer.getComfortClass();
    }

    public ComfortClass getComfortClass() {
        return comfortClass;
    }

    public String getAdditions() {
        return additions;
    }

    @Override
    public String toString() {
        return name + ": (" + coordinate.getLatitude() + ", " + coordinate.getLongitude() + ") " + comfortClass + " " + additions;
    }
}
