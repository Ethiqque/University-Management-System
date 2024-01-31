package com.ethiqque.data_generator;

import com.ethiqque.dao.impl.StudentCoursesDaoImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class StudentCoursesGenerator {

    public List<Map.Entry<Integer, Integer>> generateData() {
        Random random = new Random();
        List<Map.Entry<Integer, Integer>> studentCoursesList = new ArrayList<>();

        int totalStudents = 200;
        int totalCourses = 10;

        for (int studentId = 1; studentId <= totalStudents; studentId++) {
            int coursesCount = random.nextInt(3) + 1;
            for (int i = 0; i < coursesCount; i++) {
                int courseId = random.nextInt(totalCourses) + 1;
                studentCoursesList.add(new AbstractMap.SimpleEntry<>(studentId, courseId));
            }
        }
        return studentCoursesList;
    }
}




//package com.ethiqque.data_generator;
//
//import com.ethiqque.dao.impl.StudentCoursesDaoImpl;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class StudentCoursesGenerator {
//
//    public static void generateData(Connection connection, StudentCoursesDaoImpl studentCoursesDao) {
//        Random random = new Random();
////        String studentsSql = "SELECT student_id FROM students";
//        List<String> studentCoursesList = new ArrayList<>();
//
//        try (Statement statement = connection.createStatement();
//             ResultSet studentsResultSet = statement.executeQuery(studentsSql)) {
//
//
//            while (studentsResultSet.next()) {
//                int studentId = studentsResultSet.getInt("student_id");
//                int coursesCount = random.nextInt(3) + 1;
//
//                for (int i = 0; i < coursesCount; i++) {
//                    int courseId = random.nextInt(10) + 1;
//                    try {
//                        studentCoursesDao.addStudentCourses(studentId, courseId);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Error in adding course for student", e);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error in processing student data", e);
//        }
//    }
//}

