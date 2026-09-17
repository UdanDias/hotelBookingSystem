package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.HotelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/hotel")
@RestController
public class HotelController {
    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Hotel controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addHotel(@RequestBody HotelDTO hotelDTO){
        System.out.println(hotelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deletehotel")
    public ResponseEntity<Void> deleteHotel(@RequestParam("hotelId") String hotelId){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updatehotel")
    public ResponseEntity<HotelDTO> updateHotel(@RequestParam("hotelId") String hotelId, @RequestBody HotelDTO hotelDTO){
        System.out.println("dd");
        System.out.println(hotelDTO);
        return new ResponseEntity<HotelDTO>(HttpStatus.CREATED);
    }
}
