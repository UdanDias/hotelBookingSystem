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
    private String hotelId;
    private String roomType;
    private boolean isRoomAvailable;
    private boolean isACAvailable;
    private boolean isTvAvailable;
    private int roomSize;
}
