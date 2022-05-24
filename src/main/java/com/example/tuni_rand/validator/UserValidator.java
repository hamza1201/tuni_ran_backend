package com.example.tuni_rand.validator;

import com.example.tuni_rand.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object ;
        if (user.getPassword().length() <6){
            errors.rejectValue("password","length", "password must be at least 6 characters");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("password","match","password must match");

        }

        //confirmPassword


    }
}
