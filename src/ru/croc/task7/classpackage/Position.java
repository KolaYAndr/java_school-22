package ru.croc.task7.classpackage;

import java.util.List;

public class Position {
    private int x;
    private int y;
    private static final List<Character> list = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');


    public Position(int x, int y) {
        try {
            checkIfPositionOkThenSet(x, y);
        }
        catch (IllegalPositionException e){
            System.out.println(e.getMessage());
        }
        finally {
            this.x = 0;
            this.y = 0;
        }
    }

    private void checkIfPositionOkThenSet(int x, int y) throws IllegalPositionException {
        if (x <= 7 & y <= 7) {
            this.x = x;
            this.y = y;
        } else throw new IllegalPositionException(x, y);
    }

    @Override
    public String toString() {
        return list.get(y).toString() + (x + 1);
    }
}
