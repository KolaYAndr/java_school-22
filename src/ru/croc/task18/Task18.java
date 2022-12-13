package ru.croc.task18;

import ru.croc.task18.classes.DAO;
import ru.croc.task18.classes.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Task18 {
    public static void main(String[] args) throws SQLException {
        String productCode = "Т1";
        DAO dao = new DAO();

        System.out.println(dao.findProduct(productCode));

        Product product = new Product("Т2", "test", 1);
        System.out.println(dao.createProduct(product));

        product = new Product("Т3", "test1", 5);
        System.out.println(dao.updateProduct(product));

        dao.deleteProduct("Т3");

        String userLogin = "vasyaKolya";
        ArrayList<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Т4", "test2", 3),
                new Product("Т5", "test3", 2),
                new Product("Т6", "test4", 6)));

        System.out.println(dao.createOrder(userLogin, products));
    }
}
