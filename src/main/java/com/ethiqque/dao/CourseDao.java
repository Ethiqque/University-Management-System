package com.ethiqque.dao;

import java.util.List;
import java.util.Map.Entry;

public interface CourseDao {
    void addCourse(Entry<String, String> course);
    void addAll(List<Entry<String, String>> courses);
}
