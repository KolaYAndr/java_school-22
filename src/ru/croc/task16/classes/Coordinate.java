package ru.croc.task16.classes;

public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(String coordinate){
        String[] coordinates = coordinate.split(", ");
       this(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
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
