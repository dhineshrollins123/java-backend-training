package com.dk.week3.BillingModule.exceptions;

public class BillsNotFoundByTreatmentException extends  RuntimeException{

    public BillsNotFoundByTreatmentException(String message) {
        super(message);
    }
}
