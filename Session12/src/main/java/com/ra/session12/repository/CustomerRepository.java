package com.ra.session12.repository;

import com.ra.session12.model.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Customer register(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer1 = (Customer) session.merge(customer);
            session.getTransaction().commit();
            return customer1;
        }catch (Exception e) {
            return null;
        }
    }

    public Customer findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer = (Customer) session.createQuery("from Customer where id = :id")
                    .setParameter("id", id).getSingleResult();
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            return null;
        }
    }

    public Customer login(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer = session.createQuery("from Customer where email = :email and password = :password",Customer.class)
                    .setParameter("email",email)
                    .setParameter("password",password)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            return null;
        }
    }

    public Customer findCustomerByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer = (Customer) session.createQuery("from Customer where email = :email")
                    .setParameter("email",email)
                    .getSingleResult();
            session.getTransaction().commit();
            return customer;
        }catch (Exception e) {
            return null;
        }
    }


}
