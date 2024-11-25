package com.scotiabank.colpatria.test.dev.erros;

public enum Error {
	ERROR_HANDLER(300,"error general"),
	INVALID_CITY(852,"City Is not valid"),
	DATE_INVALID(853,"Date Is not valid");
    private final int code;
    private final String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
