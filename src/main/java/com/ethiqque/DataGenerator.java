package com.ethiqque;

import com.ethiqque.dao.CourseDao;
import com.ethiqque.dao.GroupDao;
import com.ethiqque.dao.StudentDao;
import com.ethiqque.dao.impl.CourseDaoImpl;
import com.ethiqque.dao.impl.GroupDaoImpl;
import com.ethiqque.dao.impl.StudentCoursesDaoImpl;
import com.ethiqque.dao.impl.StudentDaoImpl;
import com.ethiqque.data_generator.CourseGenerator;
import com.ethiqque.data_generator.GroupGenerator;
import com.ethiqque.data_generator.StudentGenerator;

import java.util.List;
import java.util.Map.Entry;

public class DataGenerator {
    private static CourseDao courseDao = new CourseDaoImpl();
    private static GroupDao groupDao = new GroupDaoImpl();
    private static CourseGenerator courseGenerator = new CourseGenerator();
    private static GroupGenerator groupGenerator = new GroupGenerator();

    private static StudentDao studentDao = new StudentDaoImpl();
    private static StudentGenerator studentGenerator = new StudentGenerator();

    public static void generateTestData() {
        List<Entry<String, String>> courses = courseGenerator.generateData();
        courseDao.addAll(courses);

        List<String> groups = groupGenerator.generateData();
        groupDao.addAll(groups);

        List<String[]> students = StudentGenerator.generateData(10); // Assuming 10 groups
        studentDao.addAll(students);
    }
}
