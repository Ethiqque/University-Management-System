package com.ethiqque.data_generator;

import com.ethiqque.dao.impl.CourseDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class CourseGenerator {

    public String[] COURSES = {"Math", "Biology", "Art", "Music", "English", "Literature", "French", "History", "Geography", "Physical Education"};
    public String[] COURSES_DESCRIPTION = {
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

    public List<Entry<String, String>> generateData() {
        List<Entry<String, String>> courseList = new ArrayList<>();
        for (int i = 0; i < COURSES.length; i++) {
            courseList.add(new SimpleEntry<>(COURSES[i], COURSES_DESCRIPTION[i]));
        }
        return courseList;
    }
}
