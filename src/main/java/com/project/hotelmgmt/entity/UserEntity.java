package com.project.hotelmgmt.entity;


import com.project.hotelmgmt.dto.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    private String userId;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToOne(mappedBy = "user")
    private CustomerEntity customer;
}

