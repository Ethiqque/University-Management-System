package com.ethiqque.dao.impl;

import com.ethiqque.dao.GroupDao;
import com.ethiqque.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private static final String INSERT_SQL = "INSERT INTO groups (group_name) VALUES (?)";

    @Override
    public void addGroup(String groupName) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            statement.setString(1, groupName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<String> groups) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {

            int count = 0;
            for (String group : groups) {
                statement.setString(1, group);
                statement.addBatch();

                if (++count % 100 == 0 || count == groups.size()) {
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
