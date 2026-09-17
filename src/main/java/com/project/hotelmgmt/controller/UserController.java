package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    @GetMapping("healthcheck")
    public String healthcheck(){
        return "User controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deleteuser")
    public ResponseEntity<Void> deleteUser(@RequestParam("userId") String userId){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updateuser")
    public ResponseEntity<UserDTO> updateUser(@RequestParam("userId") String userId, @RequestBody UserDTO userDTO){
        System.out.println("sdfghj");
        System.out.println("ff");
        System.out.println(userDTO);
        return new ResponseEntity<UserDTO>(HttpStatus.CREATED);

    }
}
