package org.example.internetMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionUtils {
    public final static String URL = "jdbc:mysql://localhost:3306/internetMarket";
    public final static String USER = "root";
    public final static String PASSWORD = "5B4#n5u%Pz";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
