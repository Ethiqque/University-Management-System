package com.ethiqque;

import com.ethiqque.util.DatabaseInitializer;

public class MainApplication {

    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while initializing the database", e);
        }
        DataGenerator.generateTestData();
    }
}


//package com.ethiqque;
//
//import com.ethiqque.util.DatabaseConnection;
//import com.ethiqque.util.DatabaseInitializer;
//
//import java.sql.SQLException;
//
//public class MainApplication {
//
//    public static void main(String[] args) throws SQLException {
//        DatabaseInitializer.initialize();
//        DataGenerator.generateTestData();
//    }
//}
//
