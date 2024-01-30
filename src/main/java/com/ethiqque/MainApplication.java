package com.ethiqque;

import com.ethiqque.util.DatabaseInitializer;

public class MainApplication {

    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();
            System.out.println("Database initialized successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        DataGenerator.generateTestData();

    }
}



