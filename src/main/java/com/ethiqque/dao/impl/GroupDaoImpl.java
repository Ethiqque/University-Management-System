package com.ethiqque.dao.impl;

import com.ethiqque.dao.GroupDao;
import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Override
    public void addGroup(String groupName) {
        String sql = "INSERT INTO groups (group_name) VALUES (?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, groupName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAll(List<String> groups) {
        for (String group : groups) {
            addGroup(group); // Reusing addGroup for each group in the list
        }
    }
}
