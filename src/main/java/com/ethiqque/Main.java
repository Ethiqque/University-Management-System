//package com.ethiqque;
//
//
//import org.xml.sax.SAXException;
//import javax.imageio.ImageIO;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerException;
//import javax.xml.xpath.XPathException;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.sql.*;
//
//public class Main {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String username = "postgres";
//        String password = "1234";
//        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
//        try {
////            Class.forName("org.postgres.Driver");
//            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
//            Statement stat = conn.createStatement();
//            stat.execute("DROP TABLE IF EXISTS Users");
//
//            // Create a new Users table
//            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Users (" +
//                    "id SERIAL PRIMARY KEY, " +
//                    "name CHAR(30) NOT NULL, " +
//                    "password CHAR(30) NOT NULL);");
//
//            // Insert data into Users table
//            stat.executeUpdate("INSERT INTO Users(name, password) VALUES ('Max', '123')");
//            stat.executeUpdate("INSERT INTO Users(name, password) VALUES ('otherGuy', '321')");
//
//            String userId = "1";
//            PreparedStatement preparedStatement = conn.prepareStatement("select * from Users where id = ?");
//            preparedStatement.setInt(1, Integer.parseInt(userId));
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println("userName: " + resultSet.getString("name"));
//                System.out.println("userPassword: " + resultSet.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}


//public class Main {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String username = "postgres";
//        String password = "1234";
//        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
////        Class.forName("org.postgres.Driver");
//
//        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)){
//            System.out.println("We're connected!");
//        }
//    }
//}