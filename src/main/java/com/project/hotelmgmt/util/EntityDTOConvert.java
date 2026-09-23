package com.project.hotelmgmt.util;

import com.project.hotelmgmt.dto.HotelDTO;
import com.project.hotelmgmt.entity.HotelEntity;
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




}
