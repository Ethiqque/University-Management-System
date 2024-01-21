package com.ethiqque;

import com.ethiqque.util.DatabaseInitialization;

public class MainApplication {

    public static void main(String[] args) {
        DatabaseInitialization dbInit = new DatabaseInitialization();
        dbInit.initializeDatabase();
    }
}
