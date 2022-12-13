package ru.croc.task19.classes;

import java.sql.*;

public class DAO {

    public void findAllOrdersOfCourier(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = connection.createStatement();
            try (ResultSet result = statement
                    .executeQuery("SELECT time, courier.name FROM orders JOIN courier ON COURIERNUMBER=EMPLOYEENUMBER  WHERE userid="
                                    + id + "")) {
                while (result.next()) {
                    System.out.println("Time: " + result.getString("time"));
                    System.out.println("Courier: " + result.getString("name"));
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void findByCourier(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {
            final Statement statement = connection.createStatement();
            try (ResultSet result = statement
                    .executeQuery("SELECT users.name, time, product FROM orders JOIN users ON iduser=userid WHERE couriernumber=" + id + "")) {
                while (result.next()) {
                    System.out.println("Name: " + result.getString("name"));
                    System.out.println("Time: " + result.getString("time"));
                    System.out.println("Product: " + result.getString("product"));
                    System.out.println("------------------");
                }

            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
