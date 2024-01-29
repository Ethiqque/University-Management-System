package com.ethiqque.data_generator;

import com.ethiqque.dao.GroupDao;

public class GroupGenerator {

    public static void generateData() {
        // Assume GroupDao has methods to handle database operations
        GroupDao groupDao = new GroupDao() {
            @Override
            public void addGroup(String groupName) {

            }
        };

        // Example: Add sample groups
        groupDao.addGroup("Group A");
        groupDao.addGroup("Group B");
    }
}












//package com.ethiqque;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.*;
//
//public class GroupGenerator {
//
//    public static void generateGroups(Connection connection, int count) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO groups (group_name) VALUES (?)")) {
//            List<Character> letters = new ArrayList<>();
//            for (char c = 'A'; c <= 'J'; c++) {
//                letters.add(c);
//            }
//
//            Random random = new Random();
//
//            for (int i = 10; i < 21; i++) {
//                char firstLetter;
//                char secondLetter;
//                char hyphen = '-';
//                int num = i;
//
//                do {
//                    firstLetter = letters.get(random.nextInt(10));
//                    secondLetter = letters.get(random.nextInt(10));
//                } while (firstLetter == secondLetter);
//
//                List<Character> pair = new ArrayList<>();
//                pair.add(firstLetter);
//                pair.add(secondLetter);
//                Collections.sort(pair);
//
//                String letterPair = pair.get(0) + "" + pair.get(1) + hyphen + num;
//
//                statement.setString(1, letterPair);
//                statement.executeUpdate();
//            }
//        }
//    }
//}
