
package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.BookingDTO;
import com.project.hotelmgmt.exceptions.BookingNotFoundException;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.service.BookingService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/booking")
@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("healthcheck")
    public String healthcheck() {
        return "Booking controller running";
    }

    // Add booking
    @PostMapping("addbooking")
    public ResponseEntity<Void> addBooking(
            @RequestBody BookingDTO bookingDTO) {

        if (bookingDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(bookingDTO);

            bookingService.addBooking(bookingDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (RequirementsUnavailableException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (BookingNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete booking
    @DeleteMapping("deletebooking")
    public ResponseEntity<Void> deleteBooking(
            @RequestParam("bookingId") String bookingId) {

        if (bookingId == null || bookingId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            bookingService.deleteBooking(bookingId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (BookingNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update booking
    @PatchMapping("updatebooking")
    public ResponseEntity<Void> updateBooking(
            @RequestParam("bookingId") String bookingId,
            @RequestBody BookingDTO bookingDTO) {

        if (bookingId == null || bookingId.isBlank()
                || bookingDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(bookingDTO);

            bookingService.updateBooking(bookingId, bookingDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (RequirementsUnavailableException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (BookingNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get one booking
    @GetMapping("getselectedbooking")
    public ResponseEntity<BookingDTO> getSelectedBooking(
            @RequestParam("bookingid") String bookingId) {

        if (bookingId == null || bookingId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            BookingDTO bookingDTO =
                    bookingService.getSelectedBooking(bookingId);

            return ResponseEntity.ok(bookingDTO);

        } catch (BookingNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all bookings
    @GetMapping("getallbookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {

        try {
            List<BookingDTO> bookings =
                    bookingService.getAllBookings();

            return ResponseEntity.ok(bookings);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}