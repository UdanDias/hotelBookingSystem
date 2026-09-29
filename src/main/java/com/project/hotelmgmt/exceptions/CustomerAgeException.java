package com.project.hotelmgmt.exceptions;

public class CustomerAgeException extends RuntimeException {

    public CustomerAgeException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerAgeException(String message) {
        super(message);
    }
}
