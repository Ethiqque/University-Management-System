package com.ethiqque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssignmentManager {

    public static void assignStudentsToGroups(Connection connection) throws SQLException {
        try (PreparedStatement updateStmt = connection.prepareStatement("UPDATE students SET group_id = ? WHERE student_id = ?");
             PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students");
             ResultSet rs = selectStmt.executeQuery()) {

            int groupCount = 10;
            int minGroupSize = 10;
            int maxGroupSize = 30;

            Map<Integer, Integer> groupSizes = new HashMap<>();
            Random random = new Random();

            for (int groupId = 1; groupId <= groupCount; groupId++) {
                groupSizes.put(groupId, 0);
            }

            while (rs.next()) {
                int studentId = rs.getInt("student_id");

                List<Integer> shuffledGroupIds = IntStream.rangeClosed(1, groupCount)
                        .boxed()
                        .collect(Collectors.toList());
                Collections.shuffle(shuffledGroupIds);

                int chosenGroupId = -1;
                for (int groupId : shuffledGroupIds) {
                    int currentGroupSize = groupSizes.get(groupId);
                    if (currentGroupSize < maxGroupSize) {
                        chosenGroupId = groupId;
                        break;
                    }
                }

                if (chosenGroupId != -1) {
                    updateStmt.setInt(1, chosenGroupId);
                    updateStmt.setInt(2, studentId);
                    updateStmt.executeUpdate();

                    groupSizes.put(chosenGroupId, groupSizes.get(chosenGroupId) + 1);
                }
            }
        }
    }

    public static void assignCoursesToStudents(Connection connection) throws SQLException {
        try (PreparedStatement insertStmt = connection.prepareStatement(
                "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?) ON CONFLICT DO NOTHING");
             PreparedStatement selectStmt = connection.prepareStatement("SELECT student_id FROM students")) {

            int courseCount = DataGenerator.COURSES.length;

            try (ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    int studentId = rs.getInt("student_id");
                    Set<Integer> assignedCourses = new HashSet<>();
                    int courseAssignments = DataGenerator.random.nextInt(3) + 1;

                    for (int i = 0; i < courseAssignments; i++) {
                        int courseId;
                        do {
                            courseId = DataGenerator.random.nextInt(courseCount) + 1;
                        } while (assignedCourses.contains(courseId));

                        assignedCourses.add(courseId);
                        insertStmt.setInt(1, studentId);
                        insertStmt.setInt(2, courseId);
                        insertStmt.executeUpdate();
                    }
                }
            }
        }
    }
}
