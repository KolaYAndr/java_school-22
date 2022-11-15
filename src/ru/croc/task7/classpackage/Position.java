package ru.croc.task7.classpackage;

import java.util.List;

public class Position {
    private int letter;
    private int digit;
    public static final List<Character> letters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');


    public Position(int letter, int digit) {
        try {
            checkThenSet(letter, digit);
        } catch (IllegalPositionException e) {
            System.out.println(e.getMessage());
        }
    }

    public Position(String pos) {
        int letter = letters.indexOf(pos.charAt(0));
        int digit = pos.charAt(1) - '0' - 1;
        try {
            checkThenSet(letter, digit);
        } catch (IllegalPositionException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkThenSet(int letter, int digit) throws IllegalPositionException {
        if (letter >= 0 & letter <= 7 & digit >= 0 & digit <= 7) {
            this.digit = digit;
            this.letter = letter;
        } else throw new IllegalPositionException(letter, digit);
    }

    public int getLetter() {
        return letter;
    }

    public int getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return letters.get(letter) + "" + (digit + 1);
    }
}
