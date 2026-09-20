package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.RoomDTO;
import com.project.hotelmgmt.service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    @Override
    public void addRoom(RoomDTO roomDTO){
        System.out.println("from Room service addService method");
    }

    @Override
    public void updateRoom(String roomId,RoomDTO roomDTO){
        System.out.println("from Room service updateRoom method");
    }

    @Override
    public void deleteRoom(String roomId){
        System.out.println("from Room service delete Room method");
    }

    @Override
    public RoomDTO getSelectedRoom(String roomId){
        System.out.println("from Room service  getSelectedRoom method");
        return null;
    }

    @Override
    public List<RoomDTO> getAllRooms(){
        System.out.println("from Room service getAllRooms method");
        return List.of();
    }
}
