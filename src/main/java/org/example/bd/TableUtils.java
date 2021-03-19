package org.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableUtils extends DbUtils{

    public static void createStudentsTable() {
        String query = "CREATE TABLE students (" +
                "student_id int AUTO_INCREMENT, " +
                "first_name varchar (100) NOT NULL, " +
                "last_name varchar (100) NOT NULL, " +
                "date_of_birth DATE NOT NULL, " +
                "PRIMARY KEY (student_id)"+
                ");";
        executeQuery(query);
    }

    public static void createModuleTable() {
        String query = "CREATE TABLE modules (" +
                "module_id int AUTO_INCREMENT, " +
                "module_title varchar (100) NOT NULL, " +
                "level int NOT NULL, " +
                "credits int NOT NULL, " +
                "PRIMARY KEY (module_id)"+
                ");";
        executeQuery(query);
    }

    public static void createRegistrationTable() {
        String query = "CREATE TABLE registration (" +
                "student_id int, " +
                "module_id int, " +
                "result int, " +
                "PRIMARY KEY (student_id, module_id), "+
                "FOREIGN KEY (student_id) REFERENCES students(student_id), "+
                "FOREIGN KEY (module_id) REFERENCES modules(module_id)"+
                ");";
        executeQuery(query);
    }
}




