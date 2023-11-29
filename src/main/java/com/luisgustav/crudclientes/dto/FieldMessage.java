package com.luisgustav.crudclientes.dto;

public class FieldMessage {
   //Atributos

    private String fieldName;
    private String message;

    //Construtor


    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
