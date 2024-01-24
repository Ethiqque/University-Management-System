package com.ethiqque;

import com.ethiqque.util.DatabaseConnection;
import com.ethiqque.util.DatabaseInitializer;

import java.sql.SQLException;

public class MainApplication {

    public static void main(String[] args) throws SQLException {
        DatabaseInitializer.initialize();
        DataGenerator.generateTestData();
//        DatabaseConnection.connection.close();

    }
}

