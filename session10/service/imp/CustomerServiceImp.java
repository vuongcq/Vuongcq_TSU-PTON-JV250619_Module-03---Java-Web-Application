package com.ra.session10.service.imp;

import com.ra.session10.model.Customer;
import com.ra.session10.repository.CustomerRepository;
import com.ra.session10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
       return customerRepository.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean deleteById(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return customerRepository.checkEmailExist(email);
    }

    @Override
    public boolean checkUsernameExist(String username) {
        return customerRepository.checkUsernameExist(username);
    }

    @Override
    public boolean checkPhoneExist(String phone) {
        return customerRepository.checkPhoneExist(phone);
    }
}
