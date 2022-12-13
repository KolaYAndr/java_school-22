package ru.croc.task16.classes;

public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(String coordinate) {
        String[] coordinates = coordinate.split(", ");
        double latitude = Double.parseDouble(coordinates[0]);
        double longitude = Double.parseDouble(coordinates[1]);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    int calculateDistanceTo(Coordinate coordinate) {
        return (int) Math.sqrt(Math.pow(this.longitude - coordinate.longitude, 2)
                + Math.pow(this.latitude - coordinate.latitude, 2));
    }

    @Override
    public String toString() {
        return latitude + " " + longitude;
    }
}
