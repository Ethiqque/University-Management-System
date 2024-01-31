package com.ethiqque.dao.impl;

import com.ethiqque.dao.CourseDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void addCourse(Entry<String, String> course) {
        String sql = "INSERT INTO courses (course_name, course_description) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getKey());
            statement.setString(2, course.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<Entry<String, String>> courses) {
        for (Entry<String, String> course : courses) {
            addCourse(course);
        }
    }
}
