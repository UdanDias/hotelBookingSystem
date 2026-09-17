package com.project.hotelmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {
    private String hotelId;
    private String hotelName;
    private String address;
    private int rating;
    private String phone ;
    private String location;
}
