package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.UserDTO;
import com.project.hotelmgmt.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(UserDTO userDTO) {
        System.out.println("from User service addUser method");
    }

    @Override
    public void updateUser(String userId,UserDTO userDTO){
        System.out.println("from User service updateUser method");
    }

    @Override
    public void deleteUser(String userId){
        System.out.println("from User Service deleteUser method");
    }

    @Override
    public UserDTO getSelectedUser(String userId){
        System.out.println("from User service getSelectedUser method");
        return  null;
    }

    @Override
    public List<UserDTO> getAllUsers(){
        System.out.println("from User service getAllUsers method");
        return List.of();
    }


}
