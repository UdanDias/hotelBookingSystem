package com.project.hotelmgmt.util;

import com.project.hotelmgmt.dto.*;
import com.project.hotelmgmt.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    public HotelEntity convertHotelDTOToHotelEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO,HotelEntity.class);

    }
    public HotelDTO convertHotelEntityToHotelDTO(HotelEntity hotelEntity){
        return modelMapper.map(hotelEntity,HotelDTO.class);

    }

    public List<HotelDTO> convertHotelEntityListToHotelDTOList(List<HotelEntity> hotelEntityList){
        return modelMapper.map(hotelEntityList, new TypeToken<List<HotelDTO>>(){}.getType());

    }

    public BookingEntity convertBookingDTOToBookingEntity(BookingDTO bookingDTO) {
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }

    public BookingDTO convertBookingEntityToBookingDTO(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }

    public List<BookingDTO> convertBookingEntityListToBookingDTOList(List<BookingEntity> bookingEntityList) {
        return modelMapper.map(bookingEntityList, new TypeToken<List<BookingDTO>>() {}.getType());
    }

    public RoomEntity convertRoomDTOToRoomEntity(RoomDTO roomDTO) {
        return modelMapper.map(roomDTO, RoomEntity.class);
    }

    public RoomDTO convertRoomEntityToRoomDTO(RoomEntity roomEntity) {
        return modelMapper.map(roomEntity, RoomDTO.class);
    }

    public List<RoomDTO> convertRoomEntityListToRoomDTOList(List<RoomEntity> roomEntityList) {
        return modelMapper.map(roomEntityList, new TypeToken<List<RoomDTO>>() {}.getType());
    }

    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> convertUserEntityListToUserDTOList(List<UserEntity> userEntityList) {
        return modelMapper.map(userEntityList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public CustomerEntity convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public CustomerDTO convertCustomerEntityToCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public List<CustomerDTO> convertCustomerEntityListToCustomerDTOList(List<CustomerEntity> customerEntityList) {

        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }






}
