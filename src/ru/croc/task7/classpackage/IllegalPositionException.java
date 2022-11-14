package ru.croc.task7.classpackage;

public class IllegalPositionException extends Exception{
    private final double x;
    private final double y;

    public IllegalPositionException(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Position must be from 0 to 7 for both directions";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
