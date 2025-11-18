package com.ra.session12.service;

import com.ra.session12.model.dto.CustomerDTO;
import com.ra.session12.model.dto.CustomerLoginDTO;
import com.ra.session12.model.entity.Customer;
import com.ra.session12.model.entity.CustomerLogin;
import com.ra.session12.model.entity.Role;
import com.ra.session12.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer register(CustomerDTO customerDTO){
        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        customer.setRole(Role.CUSTOMER);
        return customerRepository.register(customer);
    }

    @Transactional
    public Customer findById(long id){
        return customerRepository.findById(id);
    }

    @Transactional
    public Customer login(CustomerLoginDTO customerLogin){
        return customerRepository.login(customerLogin.getEmail(), customerLogin.getPassword());
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO){
        return Customer
                .builder()
                .customerName(customerDTO.getCustomerName())
                .phone(customerDTO.getPhone())
                .password(customerDTO.getPassword())
                .email(customerDTO.getEmail())
                .build();
    }

    @Transactional
    public Customer findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    public Customer getInfoCustomerLogin(){
        return CustomerLogin.customer;
    }
}
