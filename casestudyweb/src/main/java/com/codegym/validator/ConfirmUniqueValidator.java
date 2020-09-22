//package com.codegym.validator;
//
//import com.codegym.Service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//@Configurable
//public class ConfirmUniqueValidator implements ConstraintValidator<UniqueID, String> {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        if (customerService.noMatchID(s) == null){
//            return true;
//        }else{
//            return false;
//        }
//    }
//}
