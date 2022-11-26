package ru.croc.task10.classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bettor extends Thread {
    private final Lot lot;
    private final String name;

    public Bettor(Lot lot, String name) {
        this.name = name;
        this.lot = lot;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(lot.getEndingTime())) {
            if (!Objects.equals(lot.getBuyerName(), this.name)) {
                makeBet();
            }
        }
        this.interrupt();
    }


    private void makeBet() {
        double price = lot.getCurrentPrice() + Math.random();
        lot.bet(price, this.name);
    }
}
