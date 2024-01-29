package com.ethiqque.data_generator;

import com.ethiqque.dao.StudentDao;
import java.util.ArrayList;
import java.util.List;

public class StudentGenerator {

    public static void generateData() {
        StudentDao studentDao = new StudentDao() {
            @Override
            public void addStudent(String firstName, String lastName) {

            }
        };

        studentDao.addStudent("John", "Doe");
        studentDao.addStudent("Jane", "Doe");
    }
}








//package com.ethiqque;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;
//
//public class StudentGenerator {
//
//    public static void generateStudents(Connection connection, int count) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO students (first_name, last_name) VALUES (?, ?)")) {
//
//            Set<String> existingNames = getExistingNames(connection);
//
//            for (int i = 0; i < count; i++) {
//                String firstName;
//                String lastName;
//
//                do {
//                    firstName = DataGenerator.FIRST_NAMES[DataGenerator.random.nextInt(DataGenerator.FIRST_NAMES.length)];
//                    lastName = DataGenerator.LAST_NAMES[DataGenerator.random.nextInt(DataGenerator.LAST_NAMES.length)];
//                } while (existingNames.contains(firstName + " " + lastName));
//
//                statement.setString(1, firstName);
//                statement.setString(2, lastName);
//                statement.executeUpdate();
//                existingNames.add(firstName + " " + lastName);
//            }
//        }
//    }
//
//    private static Set<String> getExistingNames(Connection connection) throws SQLException {
//        Set<String> existingNames = new HashSet<>();
//        try (PreparedStatement statement = connection.prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM students");
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                String fullName = resultSet.getString("full_name");
//                existingNames.add(fullName);
//            }
//        }
//        return existingNames;
//    }
//}
