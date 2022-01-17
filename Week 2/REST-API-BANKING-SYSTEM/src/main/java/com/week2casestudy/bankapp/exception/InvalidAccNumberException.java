package com.week2casestudy.bankapp.exception;

public class InvalidAccNumberException extends RuntimeException {
    public InvalidAccNumberException(String message) {
        super(message);
    }
}

