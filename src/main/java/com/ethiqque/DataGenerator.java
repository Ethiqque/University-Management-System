package com.ethiqque;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DataGenerator {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Mike", "Sue", "Tom", "Lily", "Chris", "Anna", "James", "Karen", "Ivan", "Masha", "Georgiy", "Egor", "Max", "Martin", "Romeo", "Misha", "Jonny", "Kate"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Carnnegi", "Paul", "Martin", "Lee", "Perez", "Thomson", "Lewis", "Allen", "Scott", "Flores"};
    private static final String[] COURSES = {"Math", "Biology", "Art", "Music", "English", "Physics", "Chemistry", "History", "Geography", "Physical Education"};
    private static final Random random = new Random();

    private static final int GROUP_COUNT = 10;

    public static void generateTestData() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            generateGroups(connection, GROUP_COUNT);
            generateCourses(connection);
            generateStudents(connection, 200);
            assignStudentsToGroups(connection);
            assignCoursesToStudents(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error generating test data", e);
        }
    }

    public static void generateGroups(Connection connection, int count) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO groups (group_name) VALUES (?)")) {
            List<Character> letters = new ArrayList<>();
            for (char c = 'A'; c <= 'J'; c++) {
                letters.add(c);
            }

            Random random = new Random();

            for (int i = 10; i < 21; i++) {
                char firstLetter;
                char secondLetter;
                char hyphen = '-';
                int num = i;

                do {
                    firstLetter = letters.get(random.nextInt(10));
                    secondLetter = letters.get(random.nextInt(10));
                } while (firstLetter == secondLetter);

                List<Character> pair = new ArrayList<>();
                pair.add(firstLetter);
                pair.add(secondLetter);
                Collections.sort(pair);

                String letterPair = pair.get(0) + "" + pair.get(1) + hyphen + num;

                statement.setString(1, letterPair);
                statement.executeUpdate();
            }
        }
    }


    private static void generateCourses(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO courses (course_name, course_description) VALUES (?, ?)")) {
            for (String course : COURSES) {
                statement.setString(1, course);
                statement.setString(2, "Description of " + course);
                statement.executeUpdate();
            }
        }
    }

    private static void generateStudents(Connection connection, int count) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO students (first_name, last_name) VALUES (?, ?)")) {

            Set<String> existingNames = getExistingNames(connection);

            for (int i = 0; i < count; i++) {
                String firstName;
                String lastName;

                do {
                    firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                    lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                } while (existingNames.contains(firstName + " " + lastName));

                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.executeUpdate();
                existingNames.add(firstName + " " + lastName);
            }
        }
    }

    private static Set<String> getExistingNames(Connection connection) throws SQLException {
        Set<String> existingNames = new HashSet<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM students");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                existingNames.add(fullName);
            }
        }
        return existingNames;
    }

    private static void assignStudentsToGroups(Connection connection) throws SQLException {
        try (PreparedStatement updateStmt = connection.prepareStatement("UPDATE students SET group_id = ? WHERE student_id = ?");
             PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students");
             ResultSet rs = selectStmt.executeQuery()) {

            int groupCount = GROUP_COUNT;

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int groupId = random.nextInt(groupCount) + 1; // Random group id between 1 and 10
                updateStmt.setInt(1, groupId);
                updateStmt.setInt(2, studentId);
                updateStmt.executeUpdate();
            }
        }
    }

    private static void assignCoursesToStudents(Connection connection) throws SQLException {
        try (PreparedStatement insertStmt = connection.prepareStatement(
                "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING");
             PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students")) {

            int courseCount = COURSES.length;

            try (ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    int studentId = rs.getInt("student_id");
                    Set<Integer> assignedCourses = new HashSet<>();
                    int courseAssignments = random.nextInt(3) + 1; // Randomly assign 1 to 3 courses

                    for (int i = 0; i < courseAssignments; i++) {
                        int courseId;
                        do {
                            courseId = random.nextInt(courseCount) + 1;
                        } while (assignedCourses.contains(courseId));

                        assignedCourses.add(courseId);
                        insertStmt.setInt(1, studentId);
                        insertStmt.setInt(2, courseId);
                        insertStmt.executeUpdate();
                    }
                }
            }
        }
    }
}
