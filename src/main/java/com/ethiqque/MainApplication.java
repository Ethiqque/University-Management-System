package com.ethiqque;

import com.ethiqque.util.DatabaseInitialization;

import java.sql.SQLException;

public class MainApplication {

    public static void main(String[] args) {
        DatabaseInitialization dbInit = new DatabaseInitialization();
        dbInit.initializeDatabase();
        try {
            InsertingInDB.insertData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
