package com.hogwarts.register.util;

import java.io.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FetchFile {

    public FetchFile() {
    }

    public static List<String[]> fetchStudents(String studentList){
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

    /*
    public List<String[]> fetchNewWizards(String studentList){
        List<String[]> students = new LinkedList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(studentList).getFile());

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
    */
}
