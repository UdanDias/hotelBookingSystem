package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.UserDao;
import com.project.hotelmgmt.dto.UserDTO;
import com.project.hotelmgmt.entity.UserEntity;
import com.project.hotelmgmt.exceptions.UserNotFoundException;
import com.project.hotelmgmt.service.UserService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addUser(UserDTO userDTO) {
        System.out.println("from user service addUser method");

        userDTO.setUserId(UtilData.generateUserId());

        userDao.save(
                entityDTOConvert.convertUserDTOToUserEntity(userDTO)
        );
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        System.out.println("from user service updateUser method");

        UserEntity userEntity = userDao.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User Not Found"));

        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(userDTO.getRole());

        userDao.save(userEntity);
    }

    @Override
    public void deleteUser(String userId) {
        System.out.println("from user service deleteUser method");

        UserEntity userEntity = userDao.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User Not Found"));

        userDao.delete(userEntity);
    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        System.out.println("from user service getSelectedUser method");

        UserEntity userEntity = userDao.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User Not Found"));

        return entityDTOConvert.convertUserEntityToUserDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        System.out.println("from user service getAllUsers method");

        List<UserEntity> userEntityList = userDao.findAll();

        return entityDTOConvert.convertUserEntityListToUserDTOList(
                userEntityList
        );
    }
}