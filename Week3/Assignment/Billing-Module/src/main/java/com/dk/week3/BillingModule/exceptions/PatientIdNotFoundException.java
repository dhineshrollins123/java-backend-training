package com.dk.week3.BillingModule.exceptions;

public class PatientIdNotFoundException extends  RuntimeException{

    public PatientIdNotFoundException(String message) {
        super(message);
    }
}
