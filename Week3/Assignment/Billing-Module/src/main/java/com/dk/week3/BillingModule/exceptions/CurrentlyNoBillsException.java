package com.dk.week3.BillingModule.exceptions;

public class CurrentlyNoBillsException extends RuntimeException{

    public CurrentlyNoBillsException(String message) {
        super(message);
    }
}
