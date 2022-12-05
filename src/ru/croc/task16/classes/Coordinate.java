package ru.croc.task16.classes;

public class Coordinate {
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinate(String coordinate){
        this(Double.parseDouble(coordinate.split(", ")[0]), Double.parseDouble(coordinate.split(", ")[1]));
    }
    int calculateDistanceTo(Coordinate coordinate) {
        return (int) Math.sqrt(Math.pow(this.longitude - coordinate.longitude, 2)
                + Math.pow(this.latitude - coordinate.latitude, 2));
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
