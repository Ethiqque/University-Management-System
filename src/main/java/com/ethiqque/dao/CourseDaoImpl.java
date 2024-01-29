package com.ethiqque.dao;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    public void addCourse(String name, String description) {
        String sql = "INSERT INTO courses (course_name, course_description) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Exception handling
        }
    }

    @Override
    public static void addAll(List<Course> courses) {
        // Implementation for adding a list of courses
    }
}


