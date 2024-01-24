package com.ethiqque;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;


public class DataGenerator {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Mike", "Sue", "Tom", "Lily", "Chris", "Anna", "James", "Karen"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"};
private static final String[] COURSES = {"Math", "Biology", "Art", "Music", "English", "Physics", "Chemistry", "History", "Geography", "Physical Education"};
    private static Random random = new Random();

    public static void generateTestData() throws SQLException {
        generateGroups(10);
        generateCourses();
        generateStudents(200);
        assignStudentsToGroups();
        assignCoursesToStudents();
        DatabaseConnection.getConnection().close();
    }

    private static void generateGroups(int count) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO groups (group_name) VALUES (?)")) {
            for (int i = 0; i < count; i++) {
                String groupName = "G" + (i + 1);
                statement.setString(1, groupName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error generating groups", e);
        }
    }

    private static void generateCourses() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO courses (course_name, course_description) VALUES (?, ?)")) {
            for (String course : COURSES) {
                statement.setString(1, course);
                statement.setString(2, "Description of " + course);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error generating courses", e);
        }
    }

    private static void generateStudents(int count) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO students (first_name, last_name) VALUES (?, ?)")) {
            for (int i = 0; i < count; i++) {
                String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error generating students", e);
        }
    }

// Existing methods (generateGroups, generateCourses, generateStudents) remain the same

    private static void assignStudentsToGroups() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement updateStmt = connection.prepareStatement("UPDATE students SET group_id = ? WHERE student_id = ?");
            PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students");

            ResultSet rs = selectStmt.executeQuery();
            int groupCount = 10;
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                int groupId = random.nextInt(groupCount) + 1; // Random group id between 1 and 10
                updateStmt.setInt(1, groupId);
                updateStmt.setInt(2, studentId);
                updateStmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error assigning students to groups", e);
        }
    }

    private static void assignCoursesToStudents() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement insertStmt = connection.prepareStatement(
                    "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING");
            PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students");
            int courseCount = COURSES.length;

            ResultSet rs = selectStmt.executeQuery();
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
        } catch (SQLException e) {
            throw new RuntimeException("Error assigning courses to students", e);
        }
    }

}