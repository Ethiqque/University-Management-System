package com.ethiqque.dao.impl;

import com.ethiqque.dao.GroupDao;
import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
