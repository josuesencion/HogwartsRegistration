package com.hogwarts.register;

import com.hogwarts.register.db.tables.Students;
import com.hogwarts.register.util.FetchFile;

import java.util.LinkedList;
import java.util.List;

public class HogwartsApp {

    public static void main(String[] args) {
        String studentList = "src/main/resources/studentList.txt";
        Registrar.batchRegistration(studentList);
        Students.displayAllRows();
    }
}