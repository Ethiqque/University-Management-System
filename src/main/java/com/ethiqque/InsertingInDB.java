//package com.ethiqque.
//
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//public class RandomLetterPairs {
//
//    public static void main(String[] args) {
//        // Create a list of 10 different letters
//        List<Character> letters = new ArrayList<>();
//        for (char c = 'A'; c <= 'J'; c++) {
//            letters.add(c);
//        }
//
//        // Create a randomizer
//        Random random = new Random();
//
//        // Create a list to store pairs of different letters
//        List<String> letterPairs = new ArrayList<>();
//
//        // Generate 10 pairs of different letters
//        for (int i = 0; i < 10; i++) {
//            char firstLetter;
//            char secondLetter;
//
//            // Randomly select two different letters
//            do {
//                firstLetter = letters.get(random.nextInt(10));
//                secondLetter = letters.get(random.nextInt(10));
//            } while (firstLetter == secondLetter);
//
//            // Sort the letters to ensure they are in alphabetical order
//            List<Character> pair = new ArrayList<>();
//            pair.add(firstLetter);
//            pair.add(secondLetter);
//            Collections.sort(pair);
//
//            // Convert the pair to a string and add it to the list
//            String letterPair = pair.get(0) + "" + pair.get(1);
//            letterPairs.add(letterPair);
//        }
//
//        // Print the list of letter pairs
//        for (String pair : letterPairs) {
//            System.out.println(pair);
//        }
//    }
//}





//package com.ethiqque;
//
//import com.ethiqque.util.DatabaseConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class InsertingInDB {
//
//    public static void insertData() throws SQLException {
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement("""
//                INSERT INTO courses (course_name, course_description)
//                VALUES ('Biology', 'The study of living organisms and their functions'),
//                       ('Art', 'Creative expression through visual or performance mediums'),
//                       ('Math', 'The language of numbers, patterns, and logic.'),
//                       ('Geography', 'Exploration of Earth''s physical and cultural features'),
//                       ('Music', 'Creating and enjoying harmonious sound compositions'),
//                       ('English', 'Language study and literature appreciation'),
//                       ('France', 'Language, culture, and communication in French'),
//                       ('History', 'Understanding past events and societies'),
//                       ('Literature', 'Appreciating written and spoken artistic expression'),
//                       ('Physical education', 'Promoting fitness and well-being through physical activities')
//                """)) {
//            statement.executeUpdate();
//        }
//    }
//}
//
//
//
//
