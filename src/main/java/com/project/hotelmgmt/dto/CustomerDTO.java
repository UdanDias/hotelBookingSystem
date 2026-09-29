package com.project.hotelmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String NIC;
    private LocalDate dob;
    private int age;
}
