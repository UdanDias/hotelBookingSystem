package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.RoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/room")
@RestController
public class RoomController {

    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Room controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addRoom(@RequestBody RoomDTO roomDTO){
        System.out.println(roomDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deleteroom")
    public ResponseEntity<Void> deleteRoom(@RequestParam("roomId") String roomId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updateroom")
    public ResponseEntity<RoomDTO> updateRoom(@RequestParam("roomId") String roomId, @RequestBody RoomDTO roomDTO){

        System.out.println(roomDTO);
        return new ResponseEntity<RoomDTO>(HttpStatus.CREATED);
    }
}
