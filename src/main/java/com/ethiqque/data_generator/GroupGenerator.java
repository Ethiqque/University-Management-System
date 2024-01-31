package com.ethiqque.data_generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GroupGenerator {

    public List<String> generateData() {
        List<Character> letters = new ArrayList<>();
        for (char c = 'A'; c <= 'J'; c++) {
            letters.add(c);
        }

        Random random = new Random();
        List<String> groupList = new ArrayList<>();

        for (int i = 10; i < 21; i++) {
            char firstLetter;
            char secondLetter;
            char hyphen = '-';
            int num = i;

            do {
                firstLetter = letters.get(random.nextInt(letters.size()));
                secondLetter = letters.get(random.nextInt(letters.size()));
            } while (firstLetter == secondLetter);

            List<Character> pair = new ArrayList<>();
            pair.add(firstLetter);
            pair.add(secondLetter);
            Collections.sort(pair);

            String letterPair = pair.get(0) + "" + pair.get(1) + hyphen + num;
            groupList.add(letterPair);
        }

        return groupList;
    }
}
