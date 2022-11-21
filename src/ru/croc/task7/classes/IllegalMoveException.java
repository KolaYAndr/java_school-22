package ru.croc.task7.classes;

public class IllegalMoveException extends Exception {
    public final Position from;
    public final Position to;

    public IllegalMoveException(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getMessage() {
        return "Конь так не ходит " + from + "->" + to;
    }
}
