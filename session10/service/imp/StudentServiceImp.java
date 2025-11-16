package com.ra.session10.service.imp;

import com.ra.session10.model.Student;
import com.ra.session10.repository.StudentRepository;
import com.ra.session10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    public StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public String delete(int studentId) {
        Student student = findById(studentId);
        if (student != null) {
            if (student.getIsStudying()){
                return "Không thể xóa học sinh đang học";
            }
            else {
                studentRepository.delete(studentId);
                return "Xóa thành công!";
            }
        } else {
            return "Không tìm thấy học sinh";
        }
    }


}
