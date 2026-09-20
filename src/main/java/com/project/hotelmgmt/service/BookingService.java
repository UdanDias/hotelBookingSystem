package com.project.hotelmgmt.service;

import com.project.hotelmgmt.dto.BookingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingService {
    void addBooking(BookingDTO bookingDTO);
    void updateBooking(String bookingId,BookingDTO bookingDTO);
    void deleteBooking(String bookingId);
    BookingDTO getSelectedBooking(String bookingID);
    List<BookingDTO> getAllBookings();
}

