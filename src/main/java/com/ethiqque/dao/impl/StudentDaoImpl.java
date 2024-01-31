package com.ethiqque.dao.impl;

import com.ethiqque.dao.StudentDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void addStudent(String firstName, String lastName, int groupId) {
        String sql = "INSERT INTO students (first_name, last_name, group_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAll(List<String[]> students) {
        for (String[] student : students) {
            if (student.length == 3) {
                addStudent(student[0], student[1], Integer.parseInt(student[2]));
            }
        }
    }
}
