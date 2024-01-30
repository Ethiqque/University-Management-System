package com.ethiqque.data_generator;

import com.ethiqque.dao.StudentDao;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class StudentGenerator {

    private static final Random random = new Random();

    public static final String[] FIRST_NAMES = {"John", "Jane", "Mike", "Sue", "Tom", "Lily", "Chris", "Anna", "James", "Karen", "Ivan", "Masha", "Georgiy", "Egor", "Max", "Martin", "Romeo", "Misha", "Jonny", "Kate"};
    public static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Carnnegi", "Paul", "Martin", "Lee", "Perez", "Thomson", "Lewis", "Allen", "Scott", "Flores"};

    public static void generateData(StudentDao studentDao, int numberOfGroups) {
        Set<String> existingNames = new HashSet<>();

        for (int i = 0; i < 200; i++) {
            String firstName;
            String lastName;
            String fullName;
            int groupId;

            do {
                firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                fullName = firstName + " " + lastName;
                groupId = 1 + random.nextInt(numberOfGroups);
            } while (existingNames.contains(fullName));

            studentDao.addStudent(firstName, lastName, groupId);
            existingNames.add(fullName);
        }
    }
}













//package com.ethiqque.data_generator;
//
//import com.ethiqque.dao.StudentDao;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentGenerator {
//
//    public static void generateData() {
//        StudentDao studentDao = new StudentDao() {
//            @Override
//            public void addStudent(String firstName, String lastName) {
//
//            }
//        };
//
//        studentDao.addStudent("John", "Doe");
//        studentDao.addStudent("Jane", "Doe");
//    }
//}








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
