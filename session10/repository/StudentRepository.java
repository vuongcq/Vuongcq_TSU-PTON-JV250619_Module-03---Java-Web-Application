package com.ra.session10.repository;

import com.ra.session10.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int studentId);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int studentId);
}
