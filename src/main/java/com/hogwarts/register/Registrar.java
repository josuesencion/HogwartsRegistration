package com.hogwarts.register;

import com.hogwarts.register.db.beans.GradeYear;
import com.hogwarts.register.db.beans.Student;
import com.hogwarts.register.db.tables.Students;
import com.hogwarts.register.util.FetchFile;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrar {

    public static String generateStudentEmail(String name, String lastName){
        int randomNum = ThreadLocalRandom.current().nextInt(1131, 9966);
        return name.toLowerCase().charAt(0) + "" + lastName.toLowerCase().charAt(0) + randomNum + "@hogwarts.edu";
    }

    public static String generateStudentId(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int randomNum = ThreadLocalRandom.current().nextInt(1212, 9966);
        return "HG" + year + randomNum;
    }

    //For now, we are assuming the the user will not overpay...
    public static void payTuition(Student student, double payment){
        Student debtor = Students.getRow(student.getStudentId());
        if (debtor.getTuitionBalance() > 0.0) {
            debtor.setTuitionBalance(debtor.getTuitionBalance() - payment);
        }
        if (Students.update(debtor)) {
            System.out.println("Your payment was processed, your new balance is: " + debtor.getTuitionBalance());
        } else {
            System.out.println("Your transaction was not completed, try again later!");
        }
    }

    public static String sortingHat(){
        String[] houses = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
        Random rand = new Random();
        return houses[rand.nextInt(4)];
    }

    public static void batchRegistration(String file){
        Student student = new Student();
        List<String[]> students = FetchFile.fetchStudents(file);
        for (String[] stu:
                students) {
            student.setStudentId(Registrar.generateStudentId());
            student.setName(stu[0].trim());
            student.setLastName(stu[1].trim());
            student.setGradeYear(GradeYear.FRESHMAN.toString());
            student.setAge(Integer.parseInt(stu[2].trim()));
            student.setHouse(Registrar.sortingHat());
            student.setPhoneNumber(stu[3].trim());
            student.setStudentEmail(Registrar.generateStudentEmail(stu[0].trim(), stu[1].trim()));
            student.setPassword(Registrar.generatePassword());

            Students.insert(student);
        }
    }

    public static String generatePassword(){
        String password = null;
        boolean valitation = true;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        password = RandomStringUtils.random( 8, characters );

        if(validatePassword(password)){
            return password;
        } else {
            return generatePassword();
        }
    }

    private static boolean validatePassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}