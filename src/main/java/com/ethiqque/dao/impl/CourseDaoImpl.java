package com.ethiqque.dao.impl;

import com.ethiqque.dao.CourseDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;

public class CourseDaoImpl implements CourseDao {

    private String INSERT_SQL = "INSERT INTO courses (course_name, course_description) VALUES (?, ?)";

    @Override
    public void addCourse(Entry<String, String> course) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setString(1, course.getKey());
            statement.setString(2, course.getValue());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<Entry<String, String>> courses) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            int count = 0;
            for (Entry<String, String> course : courses) {
                statement.setString(1, course.getKey());
                statement.setString(2, course.getValue());
                statement.addBatch();

                if (++count % 100 == 0 || count == courses.size()) {
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
