package com.ethiqque.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Execute script to create user
            String sql = FileReader.readFile("sql/create_user.sql");
            statement.execute(sql);

            // Execute script to create database
            sql = FileReader.readFile("sql/create_database.sql");
            statement.execute(sql);

            // Execute script to create tables
            sql = FileReader.readFile("sql/create_tables.sql");
            statement.execute(sql);

            // Log or print a message indicating successful initialization
            System.out.println("Database has been initialized successfully.");
        } catch (SQLException e) {
            // Log or print the exception details
            System.err.println("Failed to initialize database: " + e.getMessage());
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}







//package com.ethiqque.util;
//
//import com.ethiqque.util.FileReader; // Make sure to import the FileReader class
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.SQLException;
//
//public class DatabaseInitializer {
//
//    public static void initialize() {
//        try (Connection connection = DatabaseConnection.getConnection();
//             Statement statement = connection.createStatement()) {
//            String sql = FileReader.readFile("sql/create_user.sql");
//            statement.execute(sql);
//            sql = FileReader.readFile("sql/create_database.sql");
//            statement.execute(sql);
//            sql = FileReader.readFile("sql/create_tables.sql");
//            statement.execute(sql);
//        } catch (SQLException e) {
//            throw new RuntimeException("Failed to initialize database", e);
//        }
//    }
//}
//
