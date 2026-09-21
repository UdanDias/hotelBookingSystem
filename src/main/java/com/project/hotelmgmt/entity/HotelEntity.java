package com.project.hotelmgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class HotelEntity {
    @Id
    private String hotelId;
    private String hotelName;
    private String address;
    private int rating;
    private String phone ;
    private String location;

    @OneToMany(mappedBy = "hotel")
    private List<RoomEntity> rooms;
}
