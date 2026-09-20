package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.CustomerDTO;
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
    public String healthcheck(){
        return "Customer controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deletecustomer")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("customerId") String customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updatecustomer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestParam("customerId") String customerId, @RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        customerService.updateCustomer(customerId, customerDTO);
        return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
    }

    @GetMapping("getselectedcustomer")
    public ResponseEntity<CustomerDTO> getSelectedCustomer(@RequestParam("customerid") String customerId){
        customerService.getSelectedCustomer(customerId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("getallcustomers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        customerService.getAllCustomers();
        return ResponseEntity.ok(null);
    }
}