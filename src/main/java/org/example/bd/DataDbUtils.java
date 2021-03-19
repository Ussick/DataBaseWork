package org.example.bd;

public class DataDbUtils extends DbUtils {

    public static void insertStudent() {
        String query = "INSERT INTO students VALUES " +
                "(1, 'Daniel', 'Radcliffe', '1995-04-23'), " +
                "(2, 'Emma', 'Watson', '1994-07-15'), " +
                "(3, 'Rupert', 'Grint', '1995-10-24');";
        executeQuery(query);
    }

    public static void insertModule() {
        String query = "INSERT INTO modules VALUES " +
                "(1, 'Math', 1, 30), " +
                "(2, 'Physics', 1, 25), " +
                "(3, 'Chemistry', 1, 40);";
        executeQuery(query);
    }

    public static void insertRegistration() {
        String query = "INSERT INTO registration VALUES " +
                "(1, 1, 5), " +
                "(1, 2, 5), " +
                "(1, 3, 5), " +
                "(2, 1, 4), " +
                "(2, 3, 5), " +
                "(3, 2, 5), " +
                "(3, 1, 3);";
        executeQuery(query);
    }


}

