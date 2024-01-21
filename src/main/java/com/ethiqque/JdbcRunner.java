package com.ethiqque;

import com.ethiqque.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Long id = 2L;
        List<Long> ids = getIdsById(id);
        System.out.println(ids);
    }

    private static List<Long> getIdsById(Long id) throws SQLException {
        String sql = "SELECT id FROM users WHERE id = ?";

        List<Long> result = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL query", e);
        }

        return result;
    }
}
