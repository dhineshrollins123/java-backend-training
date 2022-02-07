package com.RedBusApplication.signup.exception;

public class EmailAlreadyConfirmedException extends RuntimeException{

    public EmailAlreadyConfirmedException(String message) {
        super(message);
    }
}
