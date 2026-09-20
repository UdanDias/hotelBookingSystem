package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dto.HotelDTO;
import com.project.hotelmgmt.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Override
    public void addHotel(HotelDTO hotelDTO){
        System.out.println("from hotel service addHotel method");
    }

    @Override
    public void updateHotel(String hotelId, HotelDTO hotelDTO){
        System.out.println("from hotel service updateHotel method");
    }

    @Override
    public void deleteHotel(String hotelId){
        System.out.println("from hotel service deleteHotel method");
    }

    @Override
    public HotelDTO getSelectedHotel(String hotelId){
        System.out.println("from hotel service getSelectedHotel method");
        return null;
    }

    @Override
    public List<HotelDTO> getAllHotels(){
        System.out.println("from hotel service getAllHotels method");
        return List.of();
    }




}
