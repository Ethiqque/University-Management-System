package com.ethiqque.dao;

import java.util.List;

public interface GroupDao {
    void addGroup(String groupName);
    void addAll(List<String> groups); // Corrected method signature

}
