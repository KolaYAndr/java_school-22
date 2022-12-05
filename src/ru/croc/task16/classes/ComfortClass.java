package ru.croc.task16.classes;

public enum ComfortClass {
    USUAL(0), COMFORT(1), UPPER_COMFORT(2), BUSINESS(3);

    private int value;

    ComfortClass(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
