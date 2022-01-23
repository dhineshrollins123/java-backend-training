package com.dk.week3.BillingModule.exceptions;

public class NoSuchPaidBillsInDatesException extends RuntimeException{

    public NoSuchPaidBillsInDatesException(String message) {
        super(message);
    }
}
