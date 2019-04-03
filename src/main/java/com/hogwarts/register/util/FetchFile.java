package com.hogwarts.register.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FetchFile {

    public FetchFile() {
    }

    public static List<String[]> fetchStudents(String studentList){
        List<String[]> students = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(studentList));
            String entry;
            while ((entry = bufferedReader.readLine()) != null) {
                students.add(entry.split(","));
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.println("An IOException was caught :"+e.getMessage());
        }
        return students;
    }

}
