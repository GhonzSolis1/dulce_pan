package com.dulcepan.api.exception;

public class InvalidException extends BadRequest{

    private static final String DESCRIPTION = "Campo no valido";

    public InvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
