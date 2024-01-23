package com.ethiqque.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitialization {

    public void initializeDatabase() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = FileReader.readFile("sql/create_tables.sql");
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
