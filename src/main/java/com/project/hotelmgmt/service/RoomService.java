package com.project.hotelmgmt.service;

import com.project.hotelmgmt.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {
    void addRoom(RoomDTO roomDTO);
    void updateRoom(String roomId,RoomDTO roomDTO);
    void deleteRoom(String roomId);
    RoomDTO getSelectedRoom(String roomId);
    List<RoomDTO> getAllRooms();
}
