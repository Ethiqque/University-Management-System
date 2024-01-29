package com.ethiqque;

import com.ethiqque.dao.CourseDaoImpl;
import com.ethiqque.dao.GroupDaoImpl;
import com.ethiqque.dao.StudentDaoImpl;
import com.ethiqque.data_generator.CourseGenerator;
import com.ethiqque.data_generator.GroupGenerator;
import com.ethiqque.data_generator.StudentGenerator;

public class DataGenerator {
    public static void generateTestData() {
        CourseGenerator.generateData();

        GroupDaoImpl groupDaoImpl = new GroupDaoImpl();
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        CourseDaoImpl courseDaoIml = new CourseDaoImpl();

        int numberOfGroups = 10;
        GroupGenerator.generateData(groupDaoImpl);
        StudentGenerator.generateData(studentDaoImpl, numberOfGroups);


    }
}
