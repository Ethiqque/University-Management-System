package com.ethiqque.dao;

import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentCoursesDaoImpl implements StudentCoursesDao {

    private static final Logger LOGGER = Logger.getLogger(StudentCoursesDaoImpl.class.getName());

    @Override
    public void addStudentCourses(int studentId, int courseId) {
        String sql = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception in addStudentCourses", e);
        }
    }
}

