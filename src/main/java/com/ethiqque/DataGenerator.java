package com.ethiqque;

import com.ethiqque.dao.CourseDao;
import com.ethiqque.dao.GroupDao;
import com.ethiqque.dao.StudentCoursesDao;
import com.ethiqque.dao.StudentDao;
import com.ethiqque.dao.impl.CourseDaoImpl;
import com.ethiqque.dao.impl.GroupDaoImpl;
import com.ethiqque.dao.impl.StudentCoursesDaoImpl;
import com.ethiqque.dao.impl.StudentDaoImpl;
import com.ethiqque.data_generator.CourseGenerator;
import com.ethiqque.data_generator.GroupGenerator;
import com.ethiqque.data_generator.StudentCoursesGenerator;
import com.ethiqque.data_generator.StudentGenerator;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DataGenerator {
    private CourseDao courseDao;
    private GroupDao groupDao;
    private CourseGenerator courseGenerator;
    private GroupGenerator groupGenerator;

    private StudentDao studentDao;
    private StudentGenerator studentGenerator;

    private StudentCoursesDao studentCoursesDao;
    private StudentCoursesGenerator studentCoursesGenerator;

    public DataGenerator (){
            courseDao = new CourseDaoImpl();
            groupDao = new GroupDaoImpl();
            courseGenerator = new CourseGenerator();
            groupGenerator = new GroupGenerator();

            studentDao = new StudentDaoImpl();
            studentGenerator = new StudentGenerator();

            studentCoursesDao = new StudentCoursesDaoImpl();
            studentCoursesGenerator = new StudentCoursesGenerator();
        }

    public void generateTestData() {
        List<Entry<String, String>> courses = courseGenerator.generateData();
        courseDao.addAll(courses);

        List<String> groups = groupGenerator.generateData();
        groupDao.addAll(groups);

        List<String[]> students = studentGenerator.generateData(10);
        studentDao.addAll(students);

        List<Map.Entry<Integer, Integer>> studentCourses = studentCoursesGenerator.generateData();
        studentCoursesDao.addAll(studentCourses);
    }
}
