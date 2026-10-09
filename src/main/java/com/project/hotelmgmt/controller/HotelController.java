
package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.HotelDTO;
import com.project.hotelmgmt.exceptions.HotelNotFoundException;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.service.HotelService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/hotel")
@RestController
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("healthcheck")
    public String healthcheck() {
        return "Hotel controller running";
    }

    // Add hotel
    @PostMapping("addhotel")
    public ResponseEntity<Void> addHotel(
            @RequestBody HotelDTO hotelDTO) {

        if (hotelDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(hotelDTO);
            hotelService.addHotel(hotelDTO);

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

    // Delete hotel
    @DeleteMapping("deletehotel")
    public ResponseEntity<Void> deleteHotel(
            @RequestParam("hotelId") String hotelId) {

        if (hotelId == null || hotelId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            hotelService.deleteHotel(hotelId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (HotelNotFoundException e) {
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

    // Update hotel
    @PatchMapping("updatehotel")
    public ResponseEntity<Void> updateHotel(
            @RequestParam("hotelId") String hotelId,
            @RequestBody HotelDTO hotelDTO) {

        if (hotelId == null || hotelId.isBlank()
                || hotelDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(hotelDTO);
            hotelService.updateHotel(hotelId, hotelDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (HotelNotFoundException e) {
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

    // Get selected hotel
    @GetMapping("getselectedhotel")
    public ResponseEntity<HotelDTO> getSelectedHotel(
            @RequestParam("hotelId") String hotelId) {

        if (hotelId == null || hotelId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            HotelDTO hotelDTO =
                    hotelService.getSelectedHotel(hotelId);

            return ResponseEntity.ok(hotelDTO);

        } catch (HotelNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all hotels
    @GetMapping("getallhotel")
    public ResponseEntity<List<HotelDTO>> getAllHotel() {

        try {
            List<HotelDTO> hotels = hotelService.getAllHotels();

            return ResponseEntity.ok(hotels);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}