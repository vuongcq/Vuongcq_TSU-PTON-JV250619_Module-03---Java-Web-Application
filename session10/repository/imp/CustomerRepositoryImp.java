package com.ra.session10.repository.imp;

import com.ra.session10.model.Customer;
import com.ra.session10.repository.CustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return entityManager.createQuery("from Customer where id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Customer customer) {
        try {
            entityManager.persist(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Customer customer) {
        try {
            entityManager.merge(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            Customer customer = findById(id);
            entityManager.remove(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkEmailExist(String email) {
        try {
            return entityManager.createQuery("select count(c) from Customer c where c.email = :email", Long.class)
                    .setParameter("email", email).getSingleResult() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkUsernameExist(String username) {
        try {
            return entityManager.createQuery("select count (c) from Customer c where c.username = :username", Long.class)
                    .setParameter("username", username).getSingleResult() > 0;
        } catch (Exception e){
            e.printStackTrace();
        } return false;
    }

    public boolean checkPhoneExist(String phone) {
        try {
            return entityManager.createQuery("select count (c) from Customer c where c.phone = :phone", Long.class)
                    .setParameter("phone", phone).getSingleResult() > 0;
        } catch (Exception e){
            e.printStackTrace();
        } return false;
    }


}
