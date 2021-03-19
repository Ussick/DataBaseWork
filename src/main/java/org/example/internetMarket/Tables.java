package org.example.internetMarket;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {
    public static void createProductsTable(boolean flag) {
        if (flag) {
            String query = "CREATE TABLE products (" +
                    "product_id int AUTO_INCREMENT, " +
                    "name varchar (100) NOT NULL, " +
                    "category varchar (100) NOT NULL, " +
                    "price decimal(2), " +
                    "PRIMARY KEY (product_id)" +
                    ");";
            try {
                Connection connection = DbConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        }
    }

    public static void createUsersTable(boolean flag) {
        if (flag) {
            String query = "CREATE TABLE users (" +
                    "user_id int AUTO_INCREMENT, " +
                    "name varchar (100) NOT NULL, " +
                    "address varchar (100) NOT NULL, " +
                    "email varchar (100) NOT NULL, " +
                    "gender varchar (100) NOT NULL, " +
                    "date_of_birth DATE NOT NULL, " +
                    "PRIMARY KEY (user_id)" +
                    ");";
            try {
                Connection connection = DbConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        }
    }

    public static void createOrdersTable(boolean flag) {
        if (flag) {
            String query = "CREATE TABLE orders (" +
                    "user_id int, " +
                    "product_id int, " +
                    "count int NOT NULL, " +
                    "status varchar (100) NOT NULL, " +
                    "date DATE NOT NULL, " +
                    "PRIMARY KEY (user_id, product_id), " +
                    "FOREIGN KEY (user_id) REFERENCES users(user_id), " +
                    "FOREIGN KEY (product_id) REFERENCES products(product_id)" +
                    ");";
            try {
                Connection connection = DbConnectionUtils.getConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);
            }
        }
    }
}
