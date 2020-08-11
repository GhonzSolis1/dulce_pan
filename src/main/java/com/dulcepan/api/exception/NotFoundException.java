package com.dulcepan.api.exception;

public class NotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "No Encontrado";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
