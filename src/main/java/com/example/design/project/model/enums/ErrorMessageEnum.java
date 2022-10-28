package com.example.design.project.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

    INVALID_PASSWORD("Your password is not valid. Please set at least 6 AlphaNumeric characters"),
    INVALID_PASSWORD_LENGTH("Yor password length does not match"),
    INVALID_USER("User not found");


    private final String message;

    public String getMessage() {
        return message;
    }

    public String getMessage(int id) {
        return getMessage(String.valueOf(id));
    }

    public String getMessage(String text) {
        return String.join(" ", text, message);
    }
}
