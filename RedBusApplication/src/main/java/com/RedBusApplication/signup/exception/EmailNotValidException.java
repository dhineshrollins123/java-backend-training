package com.RedBusApplication.signup.exception;

public class EmailNotValidException extends RuntimeException{

    public EmailNotValidException(String message) {
        super(message);
    }
}
