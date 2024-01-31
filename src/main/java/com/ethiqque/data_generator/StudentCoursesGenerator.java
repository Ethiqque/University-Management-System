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
