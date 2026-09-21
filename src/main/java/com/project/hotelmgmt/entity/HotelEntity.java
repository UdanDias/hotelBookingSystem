package com.project.hotelmgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "hotel")
    private List<BookingEntity> bookings;
}
