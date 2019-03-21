package com.hogwarts.register.db.beans;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String studentId;
    private String name;
    private String lastName;
    private String gradeYear;
    private int age;
    private String house;
    private double tuitionBalance;
    private String phoneNumber;
    private String studentEmail;
    private String password;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGradeYear() {
        return gradeYear;
    }

    public int getAge() {
        return age;
    }

    public String getHouse() {
        return house;
    }

    public double getTuitionBalance() {
        return tuitionBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGradeYear(String gradeYear) {
        this.gradeYear = gradeYear;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setTuitionBalance(double tuitionBalance) {
        this.tuitionBalance = tuitionBalance;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gradeYear='" + gradeYear + '\'' +
                ", age=" + age +
                ", tuitionBalance=" + tuitionBalance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
