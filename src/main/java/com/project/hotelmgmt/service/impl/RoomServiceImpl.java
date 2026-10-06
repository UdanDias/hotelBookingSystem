package com.project.hotelmgmt.service.impl;

import com.project.hotelmgmt.dao.RoomDao;
import com.project.hotelmgmt.dto.RoomDTO;
import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.entity.RoomEntity;
import com.project.hotelmgmt.exceptions.BookingExistsInRoomException;
import com.project.hotelmgmt.exceptions.RoomNotFoundException;
import com.project.hotelmgmt.service.RoomService;
import com.project.hotelmgmt.util.EntityDTOConvert;
import com.project.hotelmgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addRoom(RoomDTO roomDTO) {
        System.out.println("from room service addRoom method");
        roomDTO.setRoomId(UtilData.generateRoomId());
        roomDTO.setRoomAvailable(true);
        roomDao.save(entityDTOConvert.convertRoomDTOToRoomEntity(roomDTO));
    }

    @Override
    public void updateRoom(String roomId, RoomDTO roomDTO) {
        System.out.println("from room service updateRoom method");
        RoomEntity roomEntity = roomDao.findById(roomId).orElseThrow(() -> new RoomNotFoundException("Room Not Found"));

        roomEntity.setRoomNo(roomDTO.getRoomNo());
        roomEntity.setRoomType(roomDTO.getRoomType().toString());
        roomEntity.setRoomAvailable(roomDTO.isRoomAvailable());
        roomEntity.setRoomSize(roomDTO.getRoomSize());
        roomEntity.setPrice(roomDTO.getPrice());

        roomDao.save(roomEntity);
    }

    @Override
    public void deleteRoom(String roomId) {
        System.out.println("from room service deleteRoom method");
        RoomEntity roomEntity = roomDao.findById(roomId).orElseThrow(() -> new RoomNotFoundException("Room Not Found"));

        List<BookingEntity> bookingEntities=roomEntity.getBookings();

        if (bookingEntities !=null && !bookingEntities.isEmpty()){
            throw new BookingExistsInRoomException("Room cannot be deleted,Bookings Exists");
        }
        roomDao.delete(roomEntity);
    }

    @Override
    public RoomDTO getSelectedRoom(String roomId) {
        System.out.println("from room service getSelectedRoom method");
        RoomEntity roomEntity = roomDao.findById(roomId).orElseThrow(() -> new RoomNotFoundException("Room Not Found"));
        return entityDTOConvert.convertRoomEntityToRoomDTO(roomEntity);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        System.out.println("from room service getAllRooms method");
        List<RoomEntity> roomEntityList = roomDao.findAll();
        return entityDTOConvert.convertRoomEntityListToRoomDTOList(roomEntityList);
    }

    @Override
    public void updateRoomAvailability() {

        List<RoomEntity> rooms = roomDao.findAll();

        LocalDate today = LocalDate.now();

        for (RoomEntity room : rooms) {

            boolean hasActiveBooking = false;

            List<BookingEntity> bookings = room.getBookings();

            if (bookings != null) {

                for (BookingEntity booking : bookings) {

                    if (!booking.getCheckOutDate().isBefore(today)) {
                        hasActiveBooking = true;
                        break;
                    }
                }
            }

            if (!hasActiveBooking) {
                room.setRoomAvailable(true);
                roomDao.save(room);
            }
        }
    }
}