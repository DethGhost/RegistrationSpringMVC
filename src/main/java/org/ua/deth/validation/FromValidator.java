package org.ua.deth.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.ua.deth.entity.User;

@Component
public class FromValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "error.name");
        ValidationUtils.rejectIfEmpty(errors, "login", "error.login");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.password");
    }
}
