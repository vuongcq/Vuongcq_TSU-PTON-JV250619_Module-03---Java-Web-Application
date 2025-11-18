package com.ra.session12.validator;

import com.ra.session12.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class CheckEmailUnique implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private CustomerService customerService ;
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return customerService.findCustomerByEmail(email) == null;
    }
}
