package com.dulcepan.api.exception;

public class JwtException extends RuntimeException {

    private static final String DESCRIPTION = "Jwt exception";

    public JwtException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
