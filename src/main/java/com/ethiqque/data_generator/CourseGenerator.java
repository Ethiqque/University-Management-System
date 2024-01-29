package com.ethiqque.data_generator;

import com.ethiqque.dao.CourseDaoImpl;

public class CourseGenerator {

    public static final String[] COURSES = {"Math", "Biology", "Art", "Music", "English", "Literature", "French", "History", "Geography", "Physical Education"};
    public static final String[] COURSES_DESCRIPTION = {
            "The language of numbers, patterns, and logic",
            "The study of living organisms and their functions",
            "Creative expression through visual or performance mediums",
            "Creating and enjoying harmonious sound compositions",
            "Language study and literature appreciation",
            "Appreciating written and spoken artistic expression",
            "Language, culture, and communication in French",
            "Understanding past events and societies",
            "Exploration of Earth's physical and cultural features",
            "Promoting fitness and well-being through physical activities"
    };

    public static void generateData() {
        CourseDaoImpl courseDao = new CourseDaoImpl();

        for (int i = 0; i < COURSES.length; i++) {
            courseDao.addCourse(COURSES[i], COURSES_DESCRIPTION[i]);
        }
    }
}










//package com.ethiqque.data_generator;
//
//import com.ethiqque.dao.CourseDaoImpl;
//
//public class CourseGenerator {
//
//    public static void generateData() {
//        CourseDaoImpl courseDao = new CourseDaoImpl();
//
//        courseDao.addCourse("Math", "Mathematics Course");
//        courseDao.addCourse("Biology", "Biology Course");
//    }
//}








//package com.ethiqque;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class CourseGenerator {
//
//    public static void generateCourses(Connection connection) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO courses (course_name, course_description) VALUES (?, ?)")) {
//            for (int i = 0; i < DataGenerator.COURSES.length; i++) {
//                statement.setString(1, DataGenerator.COURSES[i]);
//                statement.setString(2, DataGenerator.COURSES_DESCRIPTION[i]);
//                statement.executeUpdate();
//            }
//        }
//    }
//}
