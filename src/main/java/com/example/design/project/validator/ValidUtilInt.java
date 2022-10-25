package com.example.design.project.validator;

import com.example.design.project.exception.PasswordException;

public interface ValidUtilInt {

    void validatePassword(String password) throws PasswordException;
}
