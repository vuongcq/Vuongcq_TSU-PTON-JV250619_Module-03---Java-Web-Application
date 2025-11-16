package com.ra.session10.service;

import com.ra.session10.model.Customer;

import java.util.List;

public interface CustomerService {
List<Customer> findAll();
Customer findById(int id);
boolean save(Customer customer);
boolean update(Customer customer);
boolean deleteById(int id);
boolean checkEmailExist(String email);
boolean checkUsernameExist(String username);
boolean checkPhoneExist(String phone);
}
