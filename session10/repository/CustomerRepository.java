package com.ra.session10.repository;

import com.ra.session10.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean delete(int id);
    boolean checkEmailExist(String email);
    boolean checkUsernameExist(String username);
    boolean checkPhoneExist(String phone);

}
