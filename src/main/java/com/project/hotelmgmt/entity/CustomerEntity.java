package com.project.hotelmgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class CustomerEntity {
    @Id
    private String customerId;
    private String customerName;
    private String NIC;
    private String roomId;// since customer frontend inputs
    private String hotelId;

    @OneToMany(mappedBy = "customer")
    private List<BookingEntity> bookings;

    @OneToOne(mappedBy = "customer")
    private UserEntity user;

}


