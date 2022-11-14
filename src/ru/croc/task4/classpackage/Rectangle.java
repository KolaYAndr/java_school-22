package ru.croc.task4.classpackage;

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
}