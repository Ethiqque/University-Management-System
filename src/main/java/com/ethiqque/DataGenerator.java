package com.ethiqque;

import com.ethiqque.dao.CourseDao;
import com.ethiqque.dao.impl.CourseDaoImpl;
import com.ethiqque.dao.impl.GroupDaoImpl;
import com.ethiqque.dao.impl.StudentCoursesDaoImpl;
import com.ethiqque.dao.impl.StudentDaoImpl;
import com.ethiqque.data_generator.CourseGenerator;
import com.ethiqque.data_generator.GroupGenerator;
import com.ethiqque.data_generator.StudentCoursesGenerator;
import com.ethiqque.data_generator.StudentGenerator;
import com.ethiqque.util.DatabaseConnection;
import java.util.List;
import java.util.Map.Entry;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class DataGenerator {
    private GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
    private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    private StudentCoursesDaoImpl studentCoursesDaoImpl = new StudentCoursesDaoImpl();

    private static CourseDao courseDao = new CourseDaoImpl();

    private static CourseGenerator courseGenerator= new CourseGenerator();

    public static void generateTestData() {
        List<Map.Entry<String, String>> courses = courseGenerator.generateData();
        courseDao.addAll(courses);
    }
}



































//    public static void generateTestData() {
//        CourseGenerator.generateData();
//
//        int numberOfGroups = 10;
//        GroupGenerator.generateData(groupDaoImpl);
//        StudentGenerator.generateData(studentDaoImpl, numberOfGroups);
//
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            StudentCoursesGenerator.generateData(connection, studentCoursesDaoImpl);
//        } catch (Exception e) {
//            throw new RuntimeException("Error in generating data for StudentCourses", e);
//        }
//    }