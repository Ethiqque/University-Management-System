package com.ethiqque.dao.impl;

import com.ethiqque.dao.StudentCoursesDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentCoursesDaoImpl implements StudentCoursesDao {

    private static final String INSERT_SQL = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING";

    @Override
    public void addStudentCourse(Map.Entry<Integer, Integer> studentCourse) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setInt(1, studentCourse.getKey());
            statement.setInt(2, studentCourse.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception in addStudentCourse", e);
        }
    }

    @Override
    public void addAll(List<Map.Entry<Integer, Integer>> studentCourses) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            int count = 0;
            for (Map.Entry<Integer, Integer> studentCourse : studentCourses) {
                statement.setInt(1, studentCourse.getKey());
                statement.setInt(2, studentCourse.getValue());
                statement.addBatch();

                if (++count % 100 == 0 || count == studentCourses.size()) {
                    statement.executeBatch();
                }
            }

            if (count % 100 != 0) {
                statement.executeBatch();
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL Exception in addAll", e);
        }
    }
}
