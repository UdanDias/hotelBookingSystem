package com.project.hotelmgmt.entity;


import com.project.hotelmgmt.dto.Role;
import jakarta.persistence.*;

@Entity
public class UserEntity {
    @Id
    private String UserId;
    private String email;
    private String password;
    private Role Role;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}

