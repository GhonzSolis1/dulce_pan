package com.dulcepan.api.exception;

public class ConflictException extends RuntimeException {

    private static final String DESCRIPTION = "Conflict (409)";

    public ConflictException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
