
package com.project.hotelmgmt.controller;

import com.project.hotelmgmt.dto.UserDTO;
import com.project.hotelmgmt.exceptions.RequirementsUnavailableException;
import com.project.hotelmgmt.exceptions.UserNotFoundException;
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
    public String healthcheck() {
        return "User controller running";
    }

    // Add user
    @PostMapping
    public ResponseEntity<Void> addUser(
            @RequestBody UserDTO userDTO) {

        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(userDTO);
            userService.addUser(userDTO);

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

    // Delete user
    @DeleteMapping("deleteuser")
    public ResponseEntity<Void> deleteUser(
            @RequestParam("userId") String userId) {

        if (userId == null || userId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            userService.deleteUser(userId);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (UserNotFoundException e) {
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

    // Update user
    @PatchMapping("updateuser")
    public ResponseEntity<Void> updateUser(
            @RequestParam("userId") String userId,
            @RequestBody UserDTO userDTO) {

        if (userId == null || userId.isBlank()
                || userDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            System.out.println(userDTO);
            userService.updateUser(userId, userDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (UserNotFoundException e) {
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

    // Get selected user
    @GetMapping("getselecteduser")
    public ResponseEntity<UserDTO> getSelectedUser(
            @RequestParam("userid") String userId) {

        if (userId == null || userId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            UserDTO userDTO = userService.getSelectedUser(userId);

            return ResponseEntity.ok(userDTO);

        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all users
    @GetMapping("getallusers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        try {
            List<UserDTO> users = userService.getAllUsers();

            return ResponseEntity.ok(users);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}