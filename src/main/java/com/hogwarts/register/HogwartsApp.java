package com.hogwarts.register;

import com.hogwarts.register.db.beans.GradeYear;
import com.hogwarts.register.db.beans.Student;
import com.hogwarts.register.db.tables.Students;
import com.hogwarts.register.util.FetchFile;

import java.util.List;

public class HogwartsApp {

    public static void main(String[] args) {

        /*
        Students.displayAllRows();
        System.out.println(Students.getRow("HG20180993"));

        Student student = new Student();

        student.setStudentId("HG77770655");
        student.setName("Noah");
        student.setLastName("Serverus");
        student.setGradeYear(GradeYear.JUNIOR.toString());
        student.setAge(25);
        student.setTuitionBalance(0.0);
        student.setPhoneNumber("8093526810");
        student.setStudentEmail("hg8834@hogwarts.edu");

        Students.insert(student);
        student.setStudentEmail("ns5566@hogwarts.edu");
        Students.update(student);

        Student student1 = Students.getRow("HG20190995");
        System.out.println(student1);
        student1.setAge(29);
        Students.update(student1);
        */


        List<String[]> students = FetchFile.fetchStudents();
        for (String[] stud:
             students) {
            System.out.println(stud[0] + " " + stud[2]);
        }



    }
}