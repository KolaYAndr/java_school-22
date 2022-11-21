package ru.croc.task7.classes;

public class IllegalPositionException extends Exception {
    private final int letter;
    private final int digit;

    public IllegalPositionException(int x, int y) {
        this.letter = x;
        this.digit = y;
    }

    @Override
    public String getMessage() {
        return "Illegal position: " + (letter) + (digit);
    }

}
