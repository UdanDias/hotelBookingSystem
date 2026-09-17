package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    @GetMapping("healthcheck")
    public String healthcheck(){
        return "Customer controller running.";
    }

    @PostMapping()
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deletecustomer")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("customerId") String customerId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updateCustomer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestParam("customerId") String customerId, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerDTO,HttpStatus.CREATED);
    }
}
