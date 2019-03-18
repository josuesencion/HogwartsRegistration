package com.hogwarts.register;

import java.sql.*;

public class App {

    private static final String USERNAME = "josue";
    private static final String PASSWORD = "josue";
    private static final String MYSQL_CONN_STRING = "jdbc:mysql://localhost/practice";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(MYSQL_CONN_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int courseId = rs.getInt("course_id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String studentId = rs.getString("student_id");
                String gender = rs.getString("gender");

                System.out.print("ID: " + id);
                System.out.print(" Course ID: " + courseId);
                System.out.print(" Name: " + name);
                System.out.print(" Last Name: " + lastName);
                System.out.print(" Student ID: " + studentId);
                System.out.println(" Gender: " + gender);

            }
            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}