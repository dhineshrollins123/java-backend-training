package com.dk.week3.BillingModule.exceptions;

public class PatientAlreadyPaidException extends RuntimeException {
    public PatientAlreadyPaidException(String message) {
        super(message);
    }
}
