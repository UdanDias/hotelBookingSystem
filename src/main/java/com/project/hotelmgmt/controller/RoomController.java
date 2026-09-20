package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.RoomDTO;
import com.project.hotelmgmt.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/room")
@RestController
@RequiredArgsConstructor

public class RoomController {
    private final RoomService roomService;


    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Room controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addRoom(@RequestBody RoomDTO roomDTO){
        System.out.println(roomDTO);
        roomService.addRoom(roomDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deleteroom")
    public ResponseEntity<Void> deleteRoom(@RequestParam("roomId") String roomId){
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updateroom")
    public ResponseEntity<RoomDTO> updateRoom(@RequestParam("roomId") String roomId, @RequestBody RoomDTO roomDTO){
        System.out.println(roomDTO);
        roomService.updateRoom(roomId, roomDTO);
        return new ResponseEntity<RoomDTO>(HttpStatus.OK);
    }

    @GetMapping("getselectedroom")
    public ResponseEntity<RoomDTO> getSelectedRoom(@RequestParam("roomid") String roomId){
        roomService.getSelectedRoom(roomId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("getallrooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms(){
        roomService.getAllRooms();
        return ResponseEntity.ok(null);
    }
}