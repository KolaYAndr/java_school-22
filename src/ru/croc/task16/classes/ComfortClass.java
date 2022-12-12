package ru.croc.task16.classes;

public enum ComfortClass {
    USUAL(0), COMFORT(1), UPPER_COMFORT(2), BUSINESS(3);


    ComfortClass(int value) {
    }

    public static ComfortClass getClass(int value){
        return switch (value) {
            case 0 -> ComfortClass.USUAL;
            case 1 -> ComfortClass.COMFORT;
            case 2 -> ComfortClass.UPPER_COMFORT;
            case 3 -> ComfortClass.BUSINESS;
            default -> null;
        };

    }
}
