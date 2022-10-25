package com.example.design.project.validator;

import com.example.design.project.dao.entity.UserEntity;
import com.example.design.project.model.UserDto;
import com.example.design.project.service.serviceImplements.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private UserServiceImp userServiceImp;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUserName().length() < 3 || user.getUserName().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userServiceImp.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getUserPassword().length() < 5 || user.getsUserPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

    }

}
