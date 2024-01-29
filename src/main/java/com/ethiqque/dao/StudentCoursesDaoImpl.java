package com.ethiqque.dao;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCoursesDaoImpl implements StudentCoursesDao {

    @Override
    public void addStudentCourses(int student_id, int course_id) {
//        String sql = "INSERT INTO students (first_name, last_name) VALUES (?, ?)";
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, firstName);
//            statement.setString(2, lastName);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            // Exception handling
//        }
    }
    // Other methods as needed
}