package ru.croc.task10.classes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Lot {
    private double currentPrice;
    private String customerName;
    protected final LocalDateTime endingTime;

    //конструктор
    public Lot(double startingPrice, LocalDateTime time) {
        this.currentPrice = startingPrice;
        this.endingTime = time;
        Watcher watcher = new Watcher();
        watcher.start();
    }

    //второй конструктор, задающий стартовую цену и время окончания через константу времени
    public Lot(double startingPrice) {
        this(startingPrice, LocalDateTime.now().plus(2, ChronoUnit.SECONDS));
    }

    //метод принятия ставки с проверкой
    public synchronized void bet(double offeredPrice, String name) {
        if (offeredPrice > currentPrice & LocalDateTime.now().isBefore(endingTime)) {
            this.currentPrice = offeredPrice;
            this.customerName = name;
            System.out.println(name + " offered price " + offeredPrice + ": Accepted");
        }
    }

    public String getBuyerName() {
        if (LocalDateTime.now().isAfter(endingTime)) return customerName + " wins: " + currentPrice;
        else return "The buyer is not determined yet";
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    private class Watcher extends Thread {
        @Override
        public void run() {
            while (LocalDateTime.now().isBefore(endingTime)) {
            }
            System.out.println(getBuyerName());
            this.interrupt();
        }
    }
}
