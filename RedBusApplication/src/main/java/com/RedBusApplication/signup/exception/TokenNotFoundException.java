package com.RedBusApplication.signup.exception;

public class TokenNotFoundException extends  RuntimeException{

    public TokenNotFoundException(String message) {
        super(message);
    }
}
