
package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.RoomDTO;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.exceptions.RoomNotFoundException;
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
    public String healthcheck() {
        return "Room controller running";
    }

    // Add room
    @PostMapping
    public ResponseEntity<Void> addRoom(
            @RequestBody RoomDTO roomDTO) {

        if (roomDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(roomDTO);
            roomService.addRoom(roomDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (RequirementsUnavailableException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete room
    @DeleteMapping("deleteroom")
    public ResponseEntity<Void> deleteRoom(
            @RequestParam("roomId") String roomId) {

        if (roomId == null || roomId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            roomService.deleteRoom(roomId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (RequirementsUnavailableException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update room
    @PatchMapping("updateroom")
    public ResponseEntity<Void> updateRoom(
            @RequestParam("roomId") String roomId,
            @RequestBody RoomDTO roomDTO) {

        if (roomId == null || roomId.isBlank()
                || roomDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(roomDTO);
            roomService.updateRoom(roomId, roomDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (RequirementsUnavailableException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get selected room
    @GetMapping("getselectedroom")
    public ResponseEntity<RoomDTO> getSelectedRoom(
            @RequestParam("roomid") String roomId) {

        if (roomId == null || roomId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            RoomDTO roomDTO = roomService.getSelectedRoom(roomId);

            return ResponseEntity.ok(roomDTO);

        } catch (RoomNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all rooms
    @GetMapping("getallrooms")
    public ResponseEntity<List<RoomDTO>> getAllRooms() {

        try {
            List<RoomDTO> rooms = roomService.getAllRooms();

            return ResponseEntity.ok(rooms);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}