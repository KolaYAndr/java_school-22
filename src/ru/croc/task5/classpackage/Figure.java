package ru.croc.task5.classpackage;

import java.util.Arrays;

public abstract class Figure implements Movable {
    //поля, которые потом определим в классах-наследниках
    private final String name;
    private double[] coordinates;

    //конструктор
    public Figure(String name, double... coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private String getName() {
        return name;
    }

    protected double[] getCoordinates() {
        return coordinates;
    }

    protected void setCoordinates(double... newCoordinates) {
        this.coordinates = newCoordinates;
    }

    //метод, который определим в классах-наследниках
    abstract String getCoordinatesToStringFormat();

    //метод, который определим в классах-наследниках
    abstract boolean pointIsInside(double x, double y);

    //переопределили метод
    @Override
    public String toString() {
        return getName() + getCoordinatesToStringFormat();
    }
}
