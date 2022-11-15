package ru.croc.task7.classpackage;

public class IllegalPositionException extends Exception {
    private final int x;
    private final int y;

    public IllegalPositionException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Illegal position: " + (y) + (x + 1);
    }

}
