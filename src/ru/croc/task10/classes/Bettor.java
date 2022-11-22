package ru.croc.task10.classes;

import java.time.LocalDateTime;

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
            synchronized (lot) {
                makeBet();
            }
        }
        System.out.println(lot.getBuyerName());
        this.interrupt();
    }


    private void makeBet() {
        double price = lot.getCurrentPrice() + Math.random();
        lot.bet(price, this.name);
    }
}
