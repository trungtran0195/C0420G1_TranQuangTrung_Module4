package com.codegym.validator;

import com.codegym.Repositorys.CustomerRepositorys;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateTest implements ConstraintValidator<UniqueID, String> {

    @Autowired
    private CustomerRepositorys customerRepositorys;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (customerRepositorys == null){
            return true;
        }else{
            return customerRepositorys.findAllById(s) == null;
        }
    }
}
