package com.ethiqque.dao;

import java.util.List;
import java.util.Map;

public interface StudentCoursesDao {
    void addStudentCourse(Map.Entry<Integer, Integer> studentCourse);
    void addAll(List<Map.Entry<Integer, Integer>> studentCourses);
}
