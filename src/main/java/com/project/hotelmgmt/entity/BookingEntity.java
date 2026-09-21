package com.project.hotelmgmt.entity;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class BookingEntity {
    @Id
    private String bookingID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Time checkInTime;
    private Time checkOutTime;
    private Boolean isBookingAvailable;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "booking_room",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<RoomEntity> rooms;
}


/*Now you don't need:

private String customerId;

because:

private CustomerEntity customer;

represents that relationship.

 */
