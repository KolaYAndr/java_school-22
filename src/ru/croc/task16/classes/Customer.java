package ru.croc.task16.classes;

import java.util.Arrays;

public class Customer {
    private Coordinate coordinate;
    private ComfortClass comfortClass;
    private String[] additions;

    public Customer(Coordinate coordinate, ComfortClass comfortClass, String... additions) {
        this.coordinate = coordinate;
        this.comfortClass = comfortClass;
        this.additions = additions;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public ComfortClass getComfortClass() {
        return comfortClass;
    }

    public String[] getAdditions() {
        return additions;
    }

    @Override
    public String toString() {
        return "(" + coordinate.getLatitude() + ", " + coordinate.getLongitude() + ") " + comfortClass + " " + Arrays.toString(additions);
    }
}
