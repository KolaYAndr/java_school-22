package ru.croc.task18.classes;

import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private List<Product> products;

    public Order(int id, String customerName, List<Product> products){
        this.id = id;
        this.customerName = customerName;
        this.products = products;
    }
}
