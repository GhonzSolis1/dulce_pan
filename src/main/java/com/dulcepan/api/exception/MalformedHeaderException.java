package com.dulcepan.api.exception;

public class MalformedHeaderException  extends BadRequest {

    private static final String DESCRIPTION = "Token with wrong format";

    public MalformedHeaderException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
