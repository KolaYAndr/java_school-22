package ru.croc.task16.classes;

import java.util.Arrays;

public class Driver {
    public String name;
    public final Coordinate coordinate;
    private ComfortClass comfortClass;
    private String[] additions;

    public Driver(String name, Coordinate coordinate, ComfortClass comfortClass, String... additions) {
        this.name = name;
        this.coordinate = coordinate;
        this.comfortClass = comfortClass;
        this.additions = additions;
    }

    public boolean matchesConditions(Customer customer) {
        String[] customerAdditions = customer.getAdditions();
        if (!customerAdditions[0].equals("")) {
            //проверка на соответствие классу комфорта
            ComfortClass customerComfortClass = customer.getComfortClass();
            boolean comfortMatches = customerComfortClass == comfortClass;

            //проверяем дополнительные требования на сочетания
            boolean additionsFlag = true;
            for (String addition: customerAdditions) {
                if (!Arrays.asList(additions).contains(addition)) {
                    additionsFlag = false;
                    break;
                }
            }
            return comfortMatches && additionsFlag;
        }
        else return this.comfortClass == customer.getComfortClass();
    }

    @Override
    public String toString() {
        return name + ": (" + coordinate.getLatitude() + ", " + coordinate.getLongitude() + ") " + comfortClass + " " + Arrays.toString(additions);
    }
}
