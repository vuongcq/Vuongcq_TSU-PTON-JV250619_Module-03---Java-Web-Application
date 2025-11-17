package com.ra.ss5.ex1234.repository;

import com.ra.ss5.ex1234.model.Student;
import com.ra.ss5.util.Database;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public List<Student> getStudents(String search , String sort) {
        try (Connection connection = Database.getConnection();
             CallableStatement statement = connection.prepareCall("{call FindAllStudents(?,?)}");) {
            statement.setString(1, search);
            statement.setString(2, sort);
            List<Student> students = new ArrayList<Student>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setStudentName(rs.getString("studentName"));
                student.setBirthday(rs.getDate("birthday").toLocalDate());
                student.setEmail(rs.getString("email"));
                student.setAvgMark(rs.getDouble("avgMark"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean addStudent(Student student) {
        try (Connection connection = Database.getConnection() ;
             CallableStatement statement = connection.prepareCall("{call AddStudent(?,?,?,?)}");
        ){
            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getEmail());
            statement.setDate(3, Date.valueOf(student.getBirthday()));
            statement.setDouble(4, student.getAvgMark());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        try (Connection connection = Database.getConnection() ;
             CallableStatement statement = connection.prepareCall("{call UpdateStudent(?,?,?,?,?)}");
        ){
            statement.setLong(1,student.getId());
            statement.setString(2, student.getStudentName());
            statement.setString(3, student.getEmail());
            statement.setDate(4, Date.valueOf(student.getBirthday()));
            statement.setDouble(5, student.getAvgMark());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudentById(long id) {
        try (Connection connection = Database.getConnection() ;
             CallableStatement statement = connection.prepareCall("{call DeleteStudent(?)}");
        ){
            statement.setLong(1,id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student getStudentById(long id) {
        try (Connection connection = Database.getConnection() ;
             CallableStatement statement = connection.prepareCall("{call findStudentById(?)}");
        ){
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setStudentName(rs.getString("studentName"));
                student.setBirthday(rs.getDate("birthday").toLocalDate());
                student.setEmail(rs.getString("email"));
                student.setAvgMark(rs.getDouble("avgMark"));
                return student;
            }else {
                return null ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
