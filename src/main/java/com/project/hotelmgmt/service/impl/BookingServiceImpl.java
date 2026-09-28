package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.BookingDao;
import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.exceptions.BookingNotFoundException;
import com.project.hotelmgmt.service.BookingService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addBooking(BookingDTO bookingDTO) {
        if (bookingDTO!=null){
            bookingDTO.setBookingID(UtilData.generateBookingId());
            //check whether the booking is available
            bookingDTO.setIsBookingAvailable(true);
            System.out.println(bookingDTO);

        }

    }

    @Override
    public void updateBooking(String bookingID, BookingDTO bookingDTO) {
        System.out.println("from booking service updateBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(() -> new BookingNotFoundException("Booking Not Found"));

        bookingEntity.setCheckInDate(bookingDTO.getCheckInDate());
        bookingEntity.setCheckOutDate(bookingDTO.getCheckOutDate());
        bookingEntity.setCheckInTime(bookingDTO.getCheckInTime());
        bookingEntity.setCheckOutTime(bookingDTO.getCheckOutTime());
        bookingEntity.setIsBookingAvailable(bookingDTO.getIsBookingAvailable());

        bookingDao.save(bookingEntity);
    }

    @Override
    public void deleteBooking(String bookingID) {
        System.out.println("from booking service deleteBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(() -> new BookingNotFoundException("Booking Not Found"));
        bookingDao.delete(bookingEntity);
    }

    @Override
    public BookingDTO getSelectedBooking(String bookingID){
        System.out.println("from booking service getSelectedBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(() -> new BookingNotFoundException("Booking Not Found"));
        BookingDTO bookingDTO = entityDTOConvert.convertBookingEntityToBookingDTO(bookingEntity);
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBookings(){
        System.out.println("from booking service getAllBookings method");
        List<BookingEntity> bookingEntityList = bookingDao.findAll();
        List<BookingDTO> bookingDTOS = entityDTOConvert.convertBookingEntityListToBookingDTOList(bookingEntityList);

        return bookingDTOS;
    }
}
