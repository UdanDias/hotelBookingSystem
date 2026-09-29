package com.project.hotelmgmt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String customerId;
    private String customerName;
    private String NIC;
    private LocalDate dob;
    private int age;


    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BookingEntity> bookings;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false,unique = true)
    private UserEntity user;

}


