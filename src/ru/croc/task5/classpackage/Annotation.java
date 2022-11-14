package ru.croc.task5.classpackage;

public class Annotation {
    //определили поля
    private final Figure figure;
    private final String signature;

    //создали коструктор
    public Annotation(Figure fig, String sign){
        this.figure = fig;
        this.signature = sign;
    }

    public String getSignature() {
        return signature;
    }

    //переопределил метод
    @Override
    public String toString() {
        return figure.toString() + getSignature();
    }

    public boolean pointIsInside(double x, double y){
        return figure.pointIsInside(x, y);
    }
}