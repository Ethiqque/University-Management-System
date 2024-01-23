package com.ethiqque.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}
