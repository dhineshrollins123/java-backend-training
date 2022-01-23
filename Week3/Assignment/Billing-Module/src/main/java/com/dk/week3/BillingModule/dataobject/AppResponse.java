package com.dk.week3.BillingModule.dataobject;

import lombok.Data;

@Data
public class AppResponse <T> {
    private String status;
    private String message;
    private T body;
}
