package com.ethiqque.data_generator;

import com.ethiqque.dao.StudentDao;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

public class StudentGenerator {
    private Random random = new Random();

    public String[] FIRST_NAMES = {"John", "Jane", "Mike", "Sue", "Tom", "Lily", "Chris", "Anna", "James", "Karen", "Ivan", "Masha", "Georgiy", "Egor", "Max", "Martin", "Romeo", "Misha", "Jonny", "Kate"};
    public String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson", "Carnnegi", "Paul", "Martin", "Lee", "Perez", "Thomson", "Lewis", "Allen", "Scott", "Flores"};

    public List<String[]> generateData(int numberOfGroups) {
        Set<String> existingNames = new HashSet<>();
        List<String[]> students = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            String firstName;
            String lastName;
            String fullName;
            int groupId;

            do {
                firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
                lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
                fullName = firstName + " " + lastName;
                groupId = 1 + random.nextInt(numberOfGroups);
            } while (existingNames.contains(fullName));

            students.add(new String[]{firstName, lastName, String.valueOf(groupId)});
            existingNames.add(fullName);
        }

        return students;
    }
}








