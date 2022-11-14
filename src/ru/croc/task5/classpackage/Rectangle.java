package ru.croc.task5.classpackage;

public class Rectangle extends Figure{

    //конструктор с вызом родительского
    public Rectangle(double x1, double y1, double x2, double y2) {
        super("Rectangle", x1, y1, x2, y2);
    }

    //определили медот от родительского абстрактного класса
    @Override
    String getCoordinatesToStringFormat() {
        double[] coords = super.getCoordinates();
        return " (" + coords[0] + ", " + coords[1] + "), (" + coords[2] + ", " + coords[3] + "): ";
    }

    //сдвигаем
    @Override
    public void move(double dx, double dy) {
        double[] coords = getCoordinates();
        setCoordinates(coords[0] + dx, coords[1] + dy, coords[2] + dx, coords[3] + dy);
    }

    //проверяем внутри ли точка
    @Override
    boolean pointIsInside(double x, double y) {
        double[] coords = getCoordinates();
        return (coords[0] <= x) & (x <= coords[2]) & (coords[1] <= y) & (y <= coords[3]);
    }
}