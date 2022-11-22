package ru.croc.task7;

import ru.croc.task7.classes.IllegalMoveException;
import ru.croc.task7.classes.IllegalPositionException;
import ru.croc.task7.classes.Position;

import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        try {
            Position pos0 = new Position("c6");
            Position pos1 = new Position("b4");
            Position pos2 = new Position("c2");
            Position pos3 = new Position("k7");

            System.out.println(moveByKnight(pos0, pos1, pos2, pos3));
        } catch (IllegalPositionException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void move(List<Position> positions) throws IllegalMoveException {
        for (int i = 0; i < positions.size() - 1; i++) {
            Position currentPos = positions.get(i);
            Position nextPos = positions.get(i + 1);
            boolean flag = ((Math.abs(currentPos.getLetter() - nextPos.getLetter()) == 1
                    && Math.abs(currentPos.getDigit() - nextPos.getDigit()) == 2)
                    || (Math.abs(currentPos.getLetter() - nextPos.getLetter()) == 2
                    && Math.abs(currentPos.getDigit() - nextPos.getDigit()) == 1));
            if (!flag) {
                throw new IllegalMoveException(currentPos, nextPos);
            }
        }
    }

    public static String moveByKnight(Position... positions) {
        List<Position> poses = List.of(positions);
        try {
            move(poses);
            return "Приемлемо";
        } catch (IllegalMoveException e) {
            return e.getMessage();
        }
    }

}