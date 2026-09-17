package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.BookingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/booking")
@RestController
public class BookingController {
    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Booking controller running";
    }
    @PostMapping()
    public ResponseEntity<Void> addBooking (@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("deletebooking")
    public ResponseEntity<Void> deleteBooking(@RequestParam("bookingId") String bookingId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("Updatebooking")
    public ResponseEntity<BookingDTO> updateBooking(@RequestParam("bookingId") String bookingId,@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO);
        return new ResponseEntity<BookingDTO>(HttpStatus.CREATED);
    }
}
