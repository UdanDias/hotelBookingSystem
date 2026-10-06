package com.project.hotelmgmt.exceptions;

public class RequirementsNotMatchingException extends RuntimeException{
    public RequirementsNotMatchingException(String message) {
        super(message);
    }

    public RequirementsNotMatchingException() {
        super();
    }

    public RequirementsNotMatchingException(String message, Throwable cause) {
        super(message, cause);
    }
}
