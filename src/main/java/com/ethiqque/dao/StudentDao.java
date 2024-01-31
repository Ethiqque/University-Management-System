package com.ethiqque.dao;

import java.util.List;

public interface StudentDao {
    void addStudent(String firstName, String lastName, int groupId);
    void addAll(List<String[]> students); // Each String[] holds firstName, lastName, groupId
}
