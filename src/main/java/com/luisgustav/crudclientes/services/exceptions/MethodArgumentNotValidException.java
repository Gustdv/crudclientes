package com.luisgustav.crudclientes.services.exceptions;

import org.springframework.validation.Errors;

public class MethodArgumentNotValidException extends  RuntimeException{

    public MethodArgumentNotValidException(String msg) {
        super(msg);
    }

    public Errors getBindingResult() {

        return null;
    }
}
