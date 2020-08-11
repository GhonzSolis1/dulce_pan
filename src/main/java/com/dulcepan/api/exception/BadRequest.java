package com.dulcepan.api.exception;

public class BadRequest extends RuntimeException {

    private static final String DESCRIPTION = "Bad Request (400)";

    public BadRequest(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
