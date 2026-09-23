package com.project.hotelmgmt.exceptions;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException() {
        super();
    }

    public HotelNotFoundException(String message) {
        super(message);
    }

    public HotelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
