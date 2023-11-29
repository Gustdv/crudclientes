package com.luisgustav.crudclientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError  extends CustomError{
  //Atributos

    private List<FieldMessage> error = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getError() {
        return error;
    }

    public void addError(String fieldName, String message) {
        error.add(new FieldMessage(fieldName, message));

    }
}
