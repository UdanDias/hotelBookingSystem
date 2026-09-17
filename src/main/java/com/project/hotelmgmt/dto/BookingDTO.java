package com.project.hotelmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String bookingID ;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Time checkInTime;
    private Time checkOutTime;
    private Boolean isBookingAvailable;
    private String customerID ;
}
