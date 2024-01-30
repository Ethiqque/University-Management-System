package com.ethiqque;

import com.ethiqque.dao.CourseDaoImpl;
import com.ethiqque.dao.GroupDaoImpl;
import com.ethiqque.dao.StudentCoursesDaoImpl;
import com.ethiqque.dao.StudentDaoImpl;
import com.ethiqque.data_generator.CourseGenerator;
import com.ethiqque.data_generator.GroupGenerator;
import com.ethiqque.data_generator.StudentCoursesGenerator;
import com.ethiqque.data_generator.StudentGenerator;
import com.ethiqque.util.DatabaseConnection;

import java.sql.Connection;

public class DataGenerator {
    public static void generateTestData() {
        CourseGenerator.generateData();
        GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        StudentCoursesDaoImpl studentCoursesDaoImpl = new StudentCoursesDaoImpl();

        int numberOfGroups = 10;
        GroupGenerator.generateData(groupDaoImpl);
        StudentGenerator.generateData(studentDaoImpl, numberOfGroups);

        try (Connection connection = DatabaseConnection.getConnection()) {
            StudentCoursesGenerator.generateData(connection, studentCoursesDaoImpl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



