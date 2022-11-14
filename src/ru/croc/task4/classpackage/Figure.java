package ru.croc.task4.classpackage;

public abstract class Figure {
    //поля, которые потом определим в классах-наследниках
    private final String name;
    private final double[] coordinates;

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

    //метод, который определим в классах-наследниках
    abstract String getCoordinatesToStringFormat();

    //переопределили метод
    @Override
    public String toString() {
        return getName() + getCoordinatesToStringFormat();
    }
}