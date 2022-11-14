package src.ru.croc.task4.classpackage;

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
}