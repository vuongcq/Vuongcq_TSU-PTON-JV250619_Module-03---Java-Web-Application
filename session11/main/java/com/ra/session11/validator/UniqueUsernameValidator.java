package com.ra.session11.validator;

import com.ra.session11.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniquyeUsername, String> {

    private UserService userService;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && !userService.checkUsernameExisted(username) ;
    }
}
