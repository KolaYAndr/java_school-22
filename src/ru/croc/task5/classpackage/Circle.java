package ru.croc.task5.classpackage;

public class Circle extends Figure {
    private double r;

    //конструктор с вызовом родительского
    public Circle(double x, double y, double r) {
        super("Circle", x, y);
        this.r = r;
    }

    //определили медот от родительского абстрактного класса
    @Override
    String getCoordinatesToStringFormat() {
        double[] coords = super.getCoordinates();
        return " (" + coords[0] + ", " + coords[1] + ") " + r + ": ";
    }

    //сдвигаем
    @Override
    public void move(double dx, double dy) {
        double[] coords = getCoordinates();
        setCoordinates(coords[0] + dx, coords[1] + dy);
    }

    //проверяем внутри ли точка
    @Override
    boolean pointIsInside(double x, double y) {
        double[] coords = getCoordinates();
        return Math.pow(coords[0] - x, 2) + Math.pow(coords[1] - y, 2) <= Math.pow(r, 2);
    }
}