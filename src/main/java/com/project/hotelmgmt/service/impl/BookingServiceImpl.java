package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.service.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public void addBooking(BookingDTO bookingDTO) {
        System.out.println("from Booking service addBooking method");
    }

    @Override
    public void updateBooking(String bookingId, BookingDTO bookingDTO) {
        System.out.println("from Booking service updateBooking method");
    }

    @Override
    public void deleteBooking(String bookingId) {
        System.out.println("from Booking service delete Booking method");
    }

    @Override
    public BookingDTO getSelectedBooking(String bookingId) {
        System.out.println("from Booking service getSelectedBooking method");
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        System.out.println("from Booking service getAllBookings method");
        return List.of();
    }
}
