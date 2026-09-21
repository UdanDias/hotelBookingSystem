package com.project.hotelmgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomEntity {
    @Id
    private String roomId;
    private int roomNo;
    private String roomType;
    private boolean isRoomAvailable;
    private boolean isACAvailable;
    private boolean isTvAvailable;
    private int roomSize;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotel;

    @ManyToMany(mappedBy = "rooms")
    private List<BookingEntity> bookings;

}
