package ru.croc.task18.classes;

public class Product {
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    private String code;
    private String name;
    private int price;

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
}
