package ru.croc.task7.classpackage;

import java.util.List;

public class Position {
    private int x;
    private int y;
    public static final List<Character> list = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');


    public Position(int x, int y) {
        try {
            checkIfPositionIsOkThenSet(x, y);
        } catch (IllegalPositionException e) {
            System.out.println(e.getMessage());
        }
    }

    public Position(String pos) {
        int y = list.indexOf(pos.charAt(0));
        int x = pos.charAt(1);
        new Position(x - '0' - 1, y);
    }


    private void checkIfPositionIsOkThenSet(int x, int y) throws IllegalPositionException {
        if (x <= 7 & y <= 7) {
            this.x = x;
            this.y = y;
        } else throw new IllegalPositionException(x, y);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return list.get(y).toString() + (x + 1);
    }

}
