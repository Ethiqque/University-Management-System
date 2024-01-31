package com.ethiqque.dao.impl;

import com.ethiqque.dao.StudentCoursesDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentCoursesDaoImpl implements StudentCoursesDao {

    @Override
    public void addStudentCourse(Map.Entry<Integer, Integer> studentCourse) {
        String sql = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentCourse.getKey()); // student_id
            statement.setInt(2, studentCourse.getValue()); // course_id
            statement.executeUpdate();
        } catch (SQLException e) {
            // Consider a more sophisticated error handling strategy here
            throw new RuntimeException("SQL Exception in addStudentCourse", e);
        }
    }

    @Override
    public void addAll(List<Map.Entry<Integer, Integer>> studentCourses) {
        for (Map.Entry<Integer, Integer> studentCourse : studentCourses) {
            addStudentCourse(studentCourse);
        }
    }
}
