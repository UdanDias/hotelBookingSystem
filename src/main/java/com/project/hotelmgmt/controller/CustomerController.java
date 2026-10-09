
package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.CustomerDTO;
import com.project.hotelmgmt.exceptions.BookingNotFoundException;
import com.project.hotelmgmt.exceptions.CustomerNotFoundException;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("healthcheck")
    public String healthcheck() {
        return "Customer controller running";
    }

    // Add customer
    @PostMapping
    public ResponseEntity<Void> addCustomer(
            @RequestBody CustomerDTO customerDTO) {

        if (customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(customerDTO);
            customerService.addCustomer(customerDTO);

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

    // Delete customer
    @DeleteMapping("deletecustomer")
    public ResponseEntity<Void> deleteCustomer(
            @RequestParam("customerId") String customerId) {

        if (customerId == null || customerId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            customerService.deleteCustomer(customerId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (CustomerNotFoundException e) {
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

    // Update customer
    @PatchMapping("updatecustomer")
    public ResponseEntity<Void> updateCustomer(
            @RequestParam("customerId") String customerId,
            @RequestBody CustomerDTO customerDTO) {

        if (customerId == null || customerId.isBlank()
                || customerDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(customerDTO);
            customerService.updateCustomer(customerId, customerDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (CustomerNotFoundException e) {
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

    // Get selected customer
    @GetMapping("getselectedcustomer")
    public ResponseEntity<CustomerDTO> getSelectedCustomer(
            @RequestParam("customerid") String customerId) {

        if (customerId == null || customerId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            CustomerDTO customerDTO =
                    customerService.getSelectedCustomer(customerId);

            return ResponseEntity.ok(customerDTO);

        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all customers
    @GetMapping("getallcustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {

        try {
            List<CustomerDTO> customers =
                    customerService.getAllCustomers();

            return ResponseEntity.ok(customers);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}