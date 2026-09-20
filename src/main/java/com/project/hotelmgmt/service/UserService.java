package com.project.hotelmgmt.service;

import com.project.hotelmgmt.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(UserDTO userDTO);
    void updateUser(String userId,UserDTO userDTO);
    void deleteUser(String userId);
    UserDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers();



}
