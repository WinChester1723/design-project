package com.example.design.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PasswordException extends RuntimeException {

    public PasswordException() {
    }

    public PasswordException(String message) {
        super(message);
    }
}
