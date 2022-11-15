package ru.croc.task7;

import ru.croc.task7.classpackage.IllegalMoveException;
import ru.croc.task7.classpackage.Position;

import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        Position pos0 = new Position("g8");
        Position pos1 = new Position("e7");
        Position pos2 = new Position("e8");

        System.out.println(moveByKnight(pos0, pos1, pos2));
    }

    public static void move(List<Position> positions) throws IllegalMoveException {
        for (int i = 0; i < positions.size() - 1; i++) {
            Position currentPos = positions.get(i);
            Position nextPos = positions.get(i + 1);
            boolean flag = (Math.abs(currentPos.getLetter() - nextPos.getLetter()) == 1 & Math.abs(currentPos.getDigit() - nextPos.getDigit()) == 2 | Math.abs(currentPos.getLetter() - nextPos.getLetter()) == 2 & Math.abs(currentPos.getDigit() - nextPos.getDigit()) == 1);
            if (!flag) {
                throw new IllegalMoveException(currentPos, nextPos);
            }
        }
    }

    public static String moveByKnight(Position... positions){
        List<Position> poses = List.of(positions);
        try {
            move(poses);
        }
        catch (IllegalMoveException e){
            return e.getMessage();
        }
        return "Приемлемо";
    }

}