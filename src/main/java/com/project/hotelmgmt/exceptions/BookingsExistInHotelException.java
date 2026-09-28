package com.project.hotelmgmt.exceptions;

public class BookingsExistInHotelException extends RuntimeException {
    public BookingsExistInHotelException(String message) {
        super(message);
    }
}
