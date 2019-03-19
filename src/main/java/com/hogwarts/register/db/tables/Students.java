package com.hogwarts.register.db.tables;

import com.hogwarts.register.db.ConnectionManager;
import com.hogwarts.register.db.beans.Student;

import java.sql.*;

public class Students {
    public static void displayAllRows() {
        String sql = "SELECT * FROM students";

        try (Connection conn = ConnectionManager.connectToDb();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Students Table:");
            while (rs.next()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(rs.getInt("id") + " ");
                stringBuffer.append(rs.getString("student_id") + " ");
                stringBuffer.append(rs.getString("name") + " ");
                stringBuffer.append(rs.getString("last_name") + " ");
                stringBuffer.append(rs.getString("grade_year") + " ");
                stringBuffer.append(rs.getInt("age") + " ");
                stringBuffer.append(rs.getString("tuition_balance") + " ");
                stringBuffer.append(rs.getString("phone_number") + " ");
                stringBuffer.append(rs.getString("student_email") + " ");
                System.out.println(stringBuffer.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Student getRow(String studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";

        ResultSet rs = null;

        try (Connection conn = ConnectionManager.connectToDb();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentId(rs.getString("student_id"));
                student.setName(rs.getString("name"));
                student.setLastName(rs.getString("last_name"));
                student.setGradeYear(rs.getString("grade_year"));
                student.setAge(rs.getInt("age"));
                student.setTuitionBalance(rs.getDouble("tuition_balance"));
                student.setPhoneNumber(rs.getString("phone_number"));
                student.setStudentEmail(rs.getString("student_email"));
                return student;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insert(Student student) {
        String sql = "INSERT INTO `students` (`id`, `student_id`, `name`, `last_name`, `grade_year`, `age`," +
                " `tuition_balance`, `phone_number`, `student_email`) VALUES (NULL, ?, ?, ?, ?, ?, " +
                "?, ?, ?)";

        ResultSet rs = null;
        try (Connection conn = ConnectionManager.connectToDb();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getLastName());
            stmt.setString(4, student.getGradeYear());
            stmt.setInt(5, student.getAge());
            stmt.setDouble(6, student.getTuitionBalance());
            stmt.setString(7, student.getPhoneNumber());
            stmt.setString(8, student.getStudentEmail());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                int affectedRow = rs.getInt(1);
                student.setId(affectedRow);
                System.out.println("Row " + affectedRow + " was inserted");
                return true;
            } else {
                System.out.println("Now rows were affected");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean update(Student student) {
        String sql = "UPDATE `students` SET `name` = ?, `last_name` = ?," +
                " `grade_year` = ?, `age` = ?, `tuition_balance` = ?, `phone_number` = ?," +
                " `student_email` = ? WHERE `students`.`student_id` = ?";

        ResultSet rs = null;
        try (Connection conn = ConnectionManager.connectToDb();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastName());
            stmt.setString(3, student.getGradeYear());
            stmt.setInt(4, student.getAge());
            stmt.setDouble(5, student.getTuitionBalance());
            stmt.setString(6, student.getPhoneNumber());
            stmt.setString(7, student.getStudentEmail());
            stmt.setString(8, student.getStudentId());

            int affectedRows = stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();

            if (affectedRows == 1) {
                System.out.println("Row " + student.getId() + " was updated");
                return true;
            }else{
                System.out.println("No rows were affected");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}

























