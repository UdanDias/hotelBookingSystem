package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.HotelDTO;
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
    public String healthcheck(){
        return "Hotel controller running";
    }

    @PostMapping("addhotel")
    public ResponseEntity<Void> addHotel(@RequestBody HotelDTO hotelDTO){
        System.out.println(hotelDTO);
        hotelService.addHotel(hotelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deletehotel")
    public ResponseEntity<Void> deleteHotel(@RequestParam("hotelId") String hotelId){
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updatehotel")
    public ResponseEntity<HotelDTO> updateHotel(@RequestParam("hotelId") String hotelId, @RequestBody HotelDTO hotelDTO){
        System.out.println(hotelDTO);
        hotelService.updateHotel(hotelId, hotelDTO);
        return new ResponseEntity<HotelDTO>(HttpStatus.OK);
    }

    @GetMapping("getselectedhotel")
    public ResponseEntity<HotelDTO> getSelectedHotel(@RequestParam("hotelId") String hotelId){
        HotelDTO hotelDTO=hotelService.getSelectedHotel(hotelId);
        return new ResponseEntity<>(hotelDTO,HttpStatus.OK);
    }

    @GetMapping("getallhotel")
    public ResponseEntity<List<HotelDTO>> getAllHotel(){
        List<HotelDTO> hotelDTOS = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelDTOS);
    }
}










