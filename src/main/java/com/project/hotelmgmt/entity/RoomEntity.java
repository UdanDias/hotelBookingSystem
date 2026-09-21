package com.project.hotelmgmt.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RoomEntity {
    @Id
    private String roomId;
    private int roomNo;;
    private String roomType;
    private boolean isRoomAvailable;
    private boolean isACAvailable;
    private boolean isTvAvailable;
    private int roomSize;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @ManyToMany(mappedBy = "rooms")
    private List<BookingEntity> bookings;

}
