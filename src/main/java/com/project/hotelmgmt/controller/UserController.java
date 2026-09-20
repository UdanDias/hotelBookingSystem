package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.UserDTO;
import com.project.hotelmgmt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;


    @GetMapping("healthcheck")
    public String healthcheck(){
        return "User controller running";
    }

    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        userService.addUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("deleteuser")
    public ResponseEntity<Void> deleteUser(@RequestParam("userId") String userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("updateuser")
    public ResponseEntity<UserDTO> updateUser(@RequestParam("userId") String userId, @RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        userService.updateUser(userId, userDTO);
        return new ResponseEntity<UserDTO>(HttpStatus.OK);
    }

    @GetMapping("getselecteduser")
    public ResponseEntity<UserDTO> getSelectedUser(@RequestParam("userid") String userId){
        userService.getSelectedUser(userId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("getallusers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        userService.getAllUsers();
        return ResponseEntity.ok(null);
    }
}