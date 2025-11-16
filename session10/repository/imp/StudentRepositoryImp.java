package com.ra.session10.repository.imp;

import com.ra.session10.model.Student;
import com.ra.session10.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class StudentRepositoryImp implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    public Student findById(int studentId) {
        return entityManager.createQuery("from Student where studentId = :id",Student.class)
                .setParameter("id", studentId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Student student) {
        try {
            entityManager.persist(student);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } return false;
    }

    @Override
    @Transactional
    public boolean update(Student student) {
        try {
            entityManager.merge(student);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int studentId) {
        try {
            Student student = findById(studentId);
            entityManager.remove(student);
            return true;

        } catch (Exception e){
            e.printStackTrace();
        } return false;
    }
}
