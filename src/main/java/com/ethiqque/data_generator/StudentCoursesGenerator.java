package com.ethiqque.data_generator;

import com.ethiqque.dao.StudentCoursesDaoImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class StudentCoursesGenerator {

    public static void generateData(Connection connection, StudentCoursesDaoImpl studentCoursesDao) {
        Random random = new Random();
        String studentsSql = "SELECT student_id FROM students";

        try (Statement statement = connection.createStatement();
             ResultSet studentsResultSet = statement.executeQuery(studentsSql)) {

            while (studentsResultSet.next()) {
                int studentId = studentsResultSet.getInt("student_id");
                int coursesCount = random.nextInt(3) + 1;

                for (int i = 0; i < coursesCount; i++) {
                    int courseId = random.nextInt(10) + 1;
                    studentCoursesDao.addStudentCourses(studentId, courseId);
                    System.out.println("student_id: " + studentId + ", course_id: " + courseId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
