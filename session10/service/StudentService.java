package com.ra.session10.service;

import com.ra.session10.model.Student;
import com.ra.session10.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;


public interface StudentService {
    List<Student> findAll();
    Student findById(int studentId);
    boolean create(Student student);
    boolean update(Student student);
    String delete(int studentId);

}
