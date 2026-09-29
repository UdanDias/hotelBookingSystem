package com.project.hotelmgmt.entity;

import com.project.hotelmgmt.dto.RoomType;
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
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private boolean isRoomAvailable;
    private int roomSize;
    private double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotel;

    @ManyToMany(mappedBy = "rooms")
    private List<BookingEntity> bookings;

}
