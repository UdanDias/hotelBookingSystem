package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.service.BookingService;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookingServiceImpl implements BookingService {

    @Override
    public void addBooking(BookingDTO bookingDTO) {
        if (bookingDTO!=null){
            bookingDTO.setBookingID(UtilData.generateBookingId());
            //check whether the booking is available
            bookingDTO.setIsBookingAvailable(true);
            System.out.println(bookingDTO);
        }
//

    }

    @Override
    public void updateBooking(String bookingId, BookingDTO bookingDTO) {
//        System.out.println("from Booking service updateBooking method");


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
