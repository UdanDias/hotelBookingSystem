package com.project.hotelmgmt.service;

import com.project.hotelmgmt.dto.HotelDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    void addHotel(HotelDTO hotelDTO);
    void updateHotel(String hotelId, HotelDTO hotelDTO);
    void deleteHotel(String hotelId);
    HotelDTO getSelectedHotel(String hotelId);
    List<HotelDTO> getAllHotels();



}
