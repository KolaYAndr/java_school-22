package ru.croc.task16;

import ru.croc.task16.classes.*;

import java.util.ArrayList;

public class Task16 {
    public static void main(String[] args) {
        // агрументы принимаются в соответствии с заданием
        // первые два - координаты
        // класс комфорта передаётся третьим аргументом
        // классы: 0 - USUAL
        // 1 - COMFORT
        // 2 - UPPER_COMFORT
        // 3 - BUSINESS
        // всё, что дальше - пожелания клиента

        Helper helper = new Helper();

        Coordinate coordinate = helper.extractCoordinate(args[0], args[1]);
        ComfortClass comfortClass = helper.extractComfortClass(args[2]);
        String[] additions = helper.extractAdditions(args);

        Customer customer = new Customer(coordinate, comfortClass, additions);

        ArrayList<Driver> drivers = initDrivers();

        helper.findAndOutput(customer, drivers);
    }

    private static ArrayList<Driver> initDrivers() {
        Driver d1 = new Driver("Ivanov Ivan", new Coordinate(59.9486, 10.324), ComfortClass.COMFORT, "детское_кресло");
        Driver d2 = new Driver("Snezhana Denisova", new Coordinate(60.9386, 31.3141), ComfortClass.USUAL, "детское_кресло");
        Driver d3 = new Driver("Petrov Petr ", new Coordinate(59.9486, 15.314), ComfortClass.COMFORT, "детское_кресло");

        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);

        return drivers;
    }


}
