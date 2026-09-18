package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/booking")
@RestController
@RequiredArgsConstructor

public class BookingController {
    private final BookingService bookingService;


    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Booking controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addBooking (@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO);
        bookingService.addBooking(bookingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("deletebooking")
    public ResponseEntity<Void> deleteBooking(@RequestParam("bookingId") String bookingId){
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("updatebooking")
    public ResponseEntity<BookingDTO> updateBooking(@RequestParam("bookingId") String bookingId,@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO);
        bookingService.updateBooking(bookingId,bookingDTO);
        return new ResponseEntity<BookingDTO>(HttpStatus.OK);
    }
    @GetMapping("getselectedbooking")
    public ResponseEntity<BookingDTO> getSelectedBooking(@RequestParam("bookingid") String bookingId){
        bookingService.getSelectedBooking(bookingId);
        return ResponseEntity.ok(null);

    }

    @GetMapping("getallbookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings(){
        bookingService.getAllBookings();
        return  ResponseEntity.ok(null);
    }

}
