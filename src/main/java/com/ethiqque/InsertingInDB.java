package com.ethiqque;

import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingInDB {

    public static void insertData() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                INSERT INTO courses (course_name, course_description)
                VALUES ('Biology', 'The study of living organisms and their functions'),
                       ('Art', 'Creative expression through visual or performance mediums'),
                       ('Math', 'The language of numbers, patterns, and logic.'),
                       ('Geography', 'Exploration of Earth''s physical and cultural features'),
                       ('Music', 'Creating and enjoying harmonious sound compositions'),
                       ('English', 'Language study and literature appreciation'),
                       ('France', 'Language, culture, and communication in French'),
                       ('History', 'Understanding past events and societies'),
                       ('Literature', 'Appreciating written and spoken artistic expression'),
                       ('Physical education', 'Promoting fitness and well-being through physical activities')
                """)) {
            statement.executeUpdate();
        }
    }
}




