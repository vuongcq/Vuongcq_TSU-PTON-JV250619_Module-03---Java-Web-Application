package com.ra.session10.validator;

import com.ra.session10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniquePhoneValidator implements ConstraintValidator<UniquePhone, String> {
    @Autowired
    private CustomerService customerService;

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if (phone!=null && !customerService.checkPhoneExist(phone)){
            return true;
        }
        return false;
    }

}
