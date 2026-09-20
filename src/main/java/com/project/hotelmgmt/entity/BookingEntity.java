package com.project.hotelmgmt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;
import java.time.LocalDate;
@Entity
public class BookingEntity {
    @Id
    private String bookingID ;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Time checkInTime;
    private Time checkOutTime;
    private Boolean isBookingAvailable;



}
