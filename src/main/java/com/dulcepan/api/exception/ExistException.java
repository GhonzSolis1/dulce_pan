package com.dulcepan.api.exception;

public class ExistException  extends ConflictException {

    private static final String DESCRIPTION = "Ya Existe ";

    public ExistException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
