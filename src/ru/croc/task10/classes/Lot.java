package ru.croc.task10.classes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Lot {
    private double currentPrice;
    private String customerName;
    private final LocalDateTime endingTime;

    //конструктор
    public Lot(double startingPrice, LocalDateTime time) {
        this.currentPrice = startingPrice;
        this.endingTime = time;
    }

    //второй конструктор, задающий стартовую цену и время окончания через константу времени
    public Lot(double startingPrice) {
        this(startingPrice, LocalDateTime.now().plus(2, ChronoUnit.SECONDS));
    }

    //метод принятия ставки с проверкой
    public void bet(double offeredPrice, String name) {
        if (offeredPrice > currentPrice) {
            this.currentPrice = offeredPrice;
            this.customerName = name;
            System.out.println(name + " offered price " + offeredPrice + ": Accepted");
        }
    }

    public String getBuyerName() {
        if (LocalDateTime.now().isAfter(endingTime)) return customerName + ": " + currentPrice;
        else return "The buyer is not determined yet";
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
