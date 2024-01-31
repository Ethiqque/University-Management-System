package com.ethiqque.dao.impl;

import com.ethiqque.dao.StudentDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final String INSERT_SQL = "INSERT INTO students (first_name, last_name, group_id) VALUES (?, ?, ?)";

    @Override
    public void addStudent(String firstName, String lastName, int groupId) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<String[]> students) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            int count = 0;
            for (String[] student : students) {
                if (student.length == 3) {
                    statement.setString(1, student[0]);
                    statement.setString(2, student[1]);
                    statement.setInt(3, Integer.parseInt(student[2]));
                    statement.addBatch();

                    if (++count % 100 == 0 || count == students.size()) {
                        statement.executeBatch();
                    }
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

