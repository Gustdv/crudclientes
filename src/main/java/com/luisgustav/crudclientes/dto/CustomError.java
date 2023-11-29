package com.luisgustav.crudclientes.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomError {
      //Atributos

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    private List<FieldMessage> errors = new ArrayList<>();

    //Construtor


    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.errors = new ArrayList<>();
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }


    public String getPath() {
        return path;
    }

    public void addError(String fieldName, String errorMessage) {
        errors.add(new FieldMessage(fieldName, errorMessage));
    }
}
