package org.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
    public final static String URL = "jdbc:mysql://localhost:3306/testdb";
    public final static String USER = "root";
    public final static String PASSWORD = "5B4#n5u%Pz";

    protected static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (
                SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
