package ru.croc.task18.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public Product findProduct(String productName) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            String code = "";
            int price = 0;
            String name = "";
            final Statement statement = connection.createStatement();
            try (ResultSet result = statement.executeQuery("SELECT * FROM PRODUCT WHERE VENDORCODE = '" + productName + "'")) {
                while (result.next()) {
                    code = result.getString("vendorсode");
                    price = result.getInt("PRICE");
                    name = result.getString("product");
                }
                if (code == null)
                    return null;
                else
                    return new Product(code, name, price);

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                return null;
            }

        }
    }

    public Product createProduct(Product product) throws SQLException {
        String code = product.getCode();
        String name = product.getName();
        int price = product.getPrice();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = connection.createStatement();
            try {
                statement.execute("INSERT INTO PRODUCT (vendorсode, product, price)\n" +
                        "VALUES ('" + code + "','" + name + "'," + price + ")\n");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
        }
        return product;
    }

    public Product updateProduct(Product product) {
        String code = product.getCode();
        String name = product.getName();
        int price = product.getPrice();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("UPDATE PRODUCT SET product='" + name + "' , price=" + price
                        + " where vendorсode='" + code + "'  ");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return product;
    }

    public void deleteProduct(String productCode) {

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = connection.createStatement();
            try {
                statement.executeUpdate("DELETE FROM PRODUCT WHERE vendorсode='" + productCode + "'");
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public Order createOrder(String Name, List<Product> products) {
        int number = 0;
        String customerName = "";
        String product = "";
        ArrayList<Product> allProducts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = conn.createStatement();
            try (ResultSet result = statement.executeQuery("SElECT * FROM ORDERS WHERE customerName ='" + Name + "'")) {
                System.out.println(result);

                while (result.next()) {
                    number = result.getInt("number");
                    customerName = result.getString("customerName");
                    product = result.getString("product");

                    Product prod = findProduct(product);
                    if (prod != null) {
                        allProducts.add(prod);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }
            if (number != 0) {
                String code;
                for (Product p : products) {
                    code = p.getCode();
                    createProduct(p);
                    allProducts.add(p);
                    try {
                        statement.execute("INSERT INTO ORDERS (number, customerName, product)\n" +
                                "VALUES (" + number + ",'" + customerName + "','" + code + "')\n");
                    } catch (SQLException e) {
                        System.out.println(e.getErrorCode());
                        throw new SQLException();
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Order(number, customerName, allProducts);
    }
}

