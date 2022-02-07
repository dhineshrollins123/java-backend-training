package com.RedBusApplication.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppResponse <T>{
    private String message;
    private Boolean status;
    private T body;
}
