package com.example.design.project.validator;

import com.example.design.project.exception.PasswordException;
import com.example.design.project.model.enums.ErrorMessageEnum;
import org.springframework.stereotype.Component;

@Component
public class ValidUtilImp implements ValidUtilInt{

    @Override
    public void validatePassword(String password) {
        if(password == null || password.length() < 6 || !isAlphaNumericFiscalId(password)){
            throw new PasswordException(ErrorMessageEnum.INVALID_PASSWORD.getMessage());
        }
    }

    private boolean isAlphaNumericFiscalId(String fiscalId){
        final String regex = "^[0-9]*[a-zA-Z][a-zA-Z0-9]*$";
        return fiscalId.matches(regex);
    }
}
