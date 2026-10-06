package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.BookingDao;
import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.exceptions.BookingNotFoundException;
import com.project.hotelmgmt.exceptions.RequirementsNotMatchingException;
import com.project.hotelmgmt.service.BookingService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class BookingServiceImpl implements BookingService {
    private final BookingDao bookingDao;
    private final EntityDTOConvert entityDTOConvert;
    private final CustomerServiceImpl customerServiceImpl;

    @Override
    public void addBooking(BookingDTO bookingDTO) {

        if (bookingDTO!=null){
            if (bookingDTO.getCheckOutDate().isBefore(UtilData.generateTodayDate())){
                throw new RequirementsNotMatchingException("Check out date cannot be before current date");
            }
            bookingDTO.setBookingID(UtilData.generateBookingId());

            //check whether the room is available
            Map<String,Long> roomTypes = bookingDao.getCountByRoomTypeByHotel(bookingDTO.getHotelId());

            //roomTypes.get()
            for(String x:bookingDTO.getRoomType().keySet()){

                if(bookingDTO.getRoomType().get(x) == null|| bookingDTO.getRoomType().get(x)== 0 ){
                    continue;
                }

                if((long)bookingDTO.getRoomType().get(x)>roomTypes.get(x)){
                    System.out.println("Insufficient amount of room.");
                    return;
                }
            }
            System.out.println("Rooms are available.");
            for(String x:bookingDTO.getRoomType().keySet()) {


            }

        /*
            for ( Map.Entry<String,Integer> entry:roomTypes.entrySet()){
                bookingDTO.getRoomType().entrySet().contains(entry.getKey())
            }*/
            bookingDTO.setIsBookingAvailable(true);
            System.out.println(bookingDTO);
//call the addCustomer method
          /*  CustomerDTO customerDTO;
            customerServiceImpl.addCustomer(customerDTO);*/
            

        }

    }

    @Override
    public void updateBooking(String bookingID, BookingDTO bookingDTO) {
        System.out.println("from booking service updateBooking method");
        BookingEntity bookingEntity = bookingDao.findById(bookingID).orElseThrow(() -> new BookingNotFoundException("Booking Not Found"));

        if (bookingDTO!=null){

            LocalDate checkInDate = bookingDTO.getCheckInDate();
            LocalDate checkOutDate = bookingDTO.getCheckOutDate();
            LocalTime checkInTime = bookingDTO.getCheckInTime();
            LocalTime checkOutTime = bookingDTO.getCheckOutTime();
            LocalDate today= UtilData.generateTodayDate();
            LocalTime now=UtilData.generateCurrentTime();

            bookingEntity.setCheckInDate(checkInDate);
            bookingEntity.setCheckOutDate(checkOutDate);
            bookingEntity.setCheckInTime(checkInTime);
            bookingEntity.setCheckOutTime(checkOutTime);

            Map<String,Long> available=bookingDao.getCountByRoomTypeByHotel(bookingDTO.getHotelId());
            for (String key: available.keySet()){
                if(bookingDTO.getRoomType().get(key)==null || bookingDTO.getRoomType().get(key)==0){
                    continue;
                }
                if((long)bookingDTO.getRoomType().get(key)>available.get(key)){
                    throw new RequirementsNotMatchingException("Insufficient rooms available");
                }
            }
//            bookingEntity.setIsBookingAvailable(bookingDTO.getIsBookingAvailable());

            bookingDao.save(bookingEntity);

        }



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

    public boolean checkAvailabilityOfRoomsByDateTimePeriod(LocalDate checkInDate,LocalDate checkOutDate, LocalTime checkInTime, LocalTime checkOutTime){
        return true;
    }
}
