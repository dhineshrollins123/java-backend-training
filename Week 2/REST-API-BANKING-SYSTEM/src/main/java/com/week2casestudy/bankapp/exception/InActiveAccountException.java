package com.week2casestudy.bankapp.exception;

public class InActiveAccountException extends RuntimeException {
    public InActiveAccountException(String message) {
        super(message);
    }
}
