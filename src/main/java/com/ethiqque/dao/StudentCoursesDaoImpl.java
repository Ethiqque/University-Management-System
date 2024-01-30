package com.ethiqque.dao;

import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCoursesDaoImpl implements StudentCoursesDao {

    @Override
    public void addStudentCourses(int student_id, int course_id) {
        String sql = "INSERT INTO student_courses (student_id, course_id) SELECT s.student_id, c.course_id FROM students s, courses c";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, student_id);
            statement.setInt(2, course_id);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
