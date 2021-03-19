package org.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private static void initDb(boolean flag) {
        if (flag){
            TableUtils.createStudentsTable();
            TableUtils.createModuleTable();
            TableUtils.createRegistrationTable();
        }
    }

    private static void insetData(boolean flag) {
        if (flag){
            DataDbUtils.insertStudent();
            DataDbUtils.insertModule();
            DataDbUtils.insertRegistration();
        }
    }

    public static void main(String[] args) {
        initDb(true);
        insetData(true);

    }
}
