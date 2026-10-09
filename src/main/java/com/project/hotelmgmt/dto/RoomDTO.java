package com.project.hotelmgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private String roomId;
    private int roomNo;
    private RoomType roomType;
    private boolean isRoomAvailable;
    private int roomSize;
    private double price;
    private String hotelId;

}
