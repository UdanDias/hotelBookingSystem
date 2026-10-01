package com.project.hotelmgmt.exceptions;

public class RequirementsUnavailableException extends RuntimeException{
    public RequirementsUnavailableException(String message) {
        super(message);
    }

    public RequirementsUnavailableException() {
        super();
    }

    public RequirementsUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
