package ru.croc.task10;

import ru.croc.task10.classes.Bettor;
import ru.croc.task10.classes.Lot;

public class Task10 {
    public static void main(String[] args) {
        Lot lot = new Lot(10);

        Bettor b1 = new Bettor(lot, "Nick");
        Bettor b2 = new Bettor(lot, "Mike");
        Bettor b3 = new Bettor(lot, "Dame");

        b1.start();
        b2.start();
        b3.start();
    }
}
