package com.ethiqque;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ethiqque.AssignmentManager.assignCoursesToStudents;
import static com.ethiqque.AssignmentManager.assignStudentsToGroups;
import static com.ethiqque.CourseGenerator.generateCourses;
import static com.ethiqque.GroupGenerator.generateGroups;
import static com.ethiqque.StudentGenerator.generateStudents;

public class DataGenerator {

    public static final String[] FIRST_NAMES = {"John", "Jane", "Mike", "Sue", "Tom", "Lily", "Chris", "Anna", "James", "Karen", "Ivan", "Masha", "Georgiy", "Egor", "Max", "Martin", "Romeo", "Misha", "Jonny", "Kate"};
    public static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Carnnegi", "Paul", "Martin", "Lee", "Perez", "Thomson", "Lewis", "Allen", "Scott", "Flores"};
    public static final String[] COURSES = {"Math", "Biology", "Art", "Music", "English", "Literature", "France", "History", "Geography", "Physical Education"};
    public static final String[] COURSES_DESCRIPTION =
            {"The language of numbers, patterns, and logic",
                    "The study of living organisms and their functions",
                    "Creative expression through visual or performance mediums",
                    "Creating and enjoying harmonious sound compositions",
                    "Language study and literature appreciation",
                    "Appreciating written and spoken artistic expression",
                    "Language, culture, and communication in French",
                    "Understanding past events and societies",
                    "Exploration of Earth''s physical and cultural features",
                    "Promoting fitness and well-being through physical activities"};

    static final Random random = new Random();

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
}
