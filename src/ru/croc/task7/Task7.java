package ru.croc.task7;

import ru.croc.task7.classpackage.IllegalMoveException;
import ru.croc.task7.classpackage.Position;

import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        Position pos0 = new Position(5, 6);
        Position pos1 = new Position(5, 7);
        Position pos2 = new Position(5, 6);
        List<Position> poses = List.of(pos0, pos1, pos2);
        try {
            moveByKnight(poses);
        }
        catch (IllegalMoveException e){
            System.out.println(e.getMessage());
        }
    }

    public static void moveByKnight(List<Position> positions) throws IllegalMoveException {
        for (int i = 0; i < positions.size() - 1; i++) {
            Position currentPos = positions.get(i);
            Position nextPos = positions.get(i + 1);
            boolean flag = (Math.abs(currentPos.getX() - nextPos.getX()) == 1 & Math.abs(currentPos.getY() - nextPos.getY()) == 2 | Math.abs(currentPos.getX() - nextPos.getX()) == 2 & Math.abs(currentPos.getY() - nextPos.getY()) == 1);
            if (!flag) {
                throw new IllegalMoveException(currentPos, nextPos);
            }
        }
    }

}