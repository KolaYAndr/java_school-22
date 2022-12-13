package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Task17 {
    private static String PATH = "/C:/Users/kolay/IdeaProjects/java_school-22/src/ru/croc/task17/container/orders.csv";

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        BufferedReader csvReader = new BufferedReader(new FileReader(PATH));
        //BufferedReader csvReader = new BufferedReader(new FileReader(args[0]));
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String connectionUrl = "jdbc:h2:tcp://localhost/~/test";


        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            // выполнение запроса

            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE GOODS(" + "VENDORCODE VARCHAR(255) PRIMARY KEY, " + "PRODUCT_NAME VARCHAR(255) NOT NULL," +
                    "PRICE FLOAT)");

            statement.execute("CREATE TABLE ORDERS(" + "ID INTEGER PRIMARY KEY, " + "CUSTOMER_NAME VARCHAR(255) NOT NULL," +
                    "FOREIGN KEY (GOODS) REFERENCES GOODS(VENDORCODE))");

            String line = csvReader.readLine();
            while (line != null){
                String[] data = line.split(",");
                int order_id = Integer.parseInt(data[0]);
                String login = data[1];
                String vendorcode = data[2];
                String product_name = data[3];
                int price = Integer.parseInt(data[4]);

                try{
                    statement.execute("INSERT INTO GOODS (VENDORCODE, PRODUCT_NAME, PRICE)\n" + "VALUES(" + vendorcode + "','"
                    + product_name + "','" + price + ")\n");
                    statement.execute("INSERT INTO ORDERS (ID, CUSTOMER_NAME, )");
                } catch (SQLException e){
                    e.getErrorCode();
                }
                finally {
                    line = csvReader.readLine();
                }
            }
            csvReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
