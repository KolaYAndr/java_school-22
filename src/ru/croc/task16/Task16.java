package ru.croc.task16;

import ru.croc.task16.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Task16 {
    public static void main(String[] args) {
        // агрументы принимаются в соответствии с заданием
        // первые два - коррдинаты
        // класс комфорта передаётся третьим аргументом
        // классы: 0 - USUAL
        // 1 - COMFORT
        // 2 - UPPER_COMFORT
        // 3 - BUSINESS
        // всё, что дальше - пожелания клиента

        ComfortClass comfortClass = ComfortClass.getClass(Integer.parseInt(args[2]));
        String coordinates = args[0] + ", " + args[1];
        String[] additions = removeThreeFirstArguments(args);
        Customer customer = new Customer(new Coordinate(coordinates), comfortClass, additions);

        ArrayList<Driver> drivers = initDrivers();

        Driver driver = findResult(customer, drivers);
        System.out.println(driver + " is the best choice");
    }

    private static Driver findResult(Customer customer, List<Driver> drivers) {
        Finder finder = new Finder(customer, drivers);
        return finder.getClosestFitting();
    }

    private static ArrayList<Driver> initDrivers() {
        Driver d1 = new Driver("Snezhana Denisova", new Coordinate(60.9386, 31.3141), ComfortClass.USUAL, "детское кресло");
        Driver d2 = new Driver("Ivanov Ivan", new Coordinate(59.9486, 10.324), ComfortClass.COMFORT, "детское кресло");
        Driver d3 = new Driver("Petrov Petr ", new Coordinate(59.9486, 15.314), ComfortClass.COMFORT, "детское кресло");

        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);

        return drivers;
    }

    private static String[] removeThreeFirstArguments(String[] args){
        StringBuilder result = new StringBuilder();

        for (int i = 3; i <= args.length; i++){
            result.append(args[i]).append(" ");
        }

        return result.toString().split(" ");
    }
}
