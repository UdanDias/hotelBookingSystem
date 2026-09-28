package com.project.hotelmgmt.exceptions;

public class BookingExistsInRoomException extends RuntimeException {


    public BookingExistsInRoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingExistsInRoomException(String message) {
        super(message);
    }
}
