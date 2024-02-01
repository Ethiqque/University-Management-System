package com.ethiqque.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class FileReader {

    public static String readFile(String filePath) {
        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}












//package com.ethiqque.util;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.stream.Collectors;
//
//public class FileReader {
//
//    public static String readFile(String filePath) {
//        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(filePath);
//
//        if (inputStream == null) {
//            throw new IllegalArgumentException("File not found: " + filePath);
//        }
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
//            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to read file: " + filePath, e);
//        }
//    }
//}
