package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.HotelDao;
import com.project.hotelmgmt.dto.HotelDTO;
import com.project.hotelmgmt.entity.HotelEntity;
import com.project.hotelmgmt.exceptions.HotelNotFoundException;
import com.project.hotelmgmt.service.HotelService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelDao hotelDao;
    private final EntityDTOConvert entityDTOConvert;
    @Override
    public void addHotel(HotelDTO hotelDTO){
        System.out.println("from hotel service addHotel method");
        hotelDTO.setHotelId(UtilData.generateHotelId());
        hotelDao.save(entityDTOConvert.convertHotelDTOToHotelEntity(hotelDTO));

    }

    @Override
    public void updateHotel(String hotelId, HotelDTO hotelDTO){
        System.out.println("from hotel service updateHotel method");
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel Not Found"));

        hotelEntity.setHotelName(hotelDTO.getHotelName());
        hotelEntity.setAddress(hotelDTO.getAddress());
        hotelEntity.setLocation(hotelDTO.getLocation());
        hotelEntity.setPhone(hotelDTO.getPhone());
        hotelEntity.setRating(hotelDTO.getRating());

        hotelDao.save(hotelEntity);
    }

    @Override
    public void deleteHotel(String hotelId){
        System.out.println("from hotel service deleteHotel method");
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel Not Found"));
        hotelDao.delete(hotelEntity);
    }

    @Override
    public HotelDTO getSelectedHotel(String hotelId){
        System.out.println("from hotel service getSelectedHotel method");
        HotelEntity hotelEntity=hotelDao.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel Not Found"));
        HotelDTO hotelDTO= entityDTOConvert.convertHotelEntityToHotelDTO(hotelEntity);
        return hotelDTO;
    }

    @Override
    public List<HotelDTO> getAllHotels(){
        System.out.println("from hotel service getAllHotels method");
        List<HotelEntity> hotelEntityList=hotelDao.findAll();
        List<HotelDTO> hotelDTOS = entityDTOConvert.convertHotelEntityListToHotelDTOList(hotelEntityList);
        return hotelDTOS;
    }




}
