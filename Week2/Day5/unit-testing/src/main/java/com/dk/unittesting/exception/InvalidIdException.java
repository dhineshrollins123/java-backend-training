package com.dk.unittesting.exception;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String message) {
        super(message);
    }
}
