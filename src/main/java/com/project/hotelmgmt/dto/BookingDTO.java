package com.project.hotelmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String bookingID ;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private Boolean isBookingAvailable=false;
    private String hotelId;
    private Map<String,Integer> roomType;
    private List<String> roomList;
    private String hotelName;






}
