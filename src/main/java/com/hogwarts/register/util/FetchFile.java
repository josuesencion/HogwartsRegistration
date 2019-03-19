package com.hogwarts.register.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FetchFile {

    private static String studentList = "data/studentList.txt";
    private String courseList = "";

    public static List<String[]> fetchStudents(){
        List<String[]> students = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(studentList));
            while (bufferedReader.readLine() != null) {
                students.add(bufferedReader.readLine().split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;


    }
}
