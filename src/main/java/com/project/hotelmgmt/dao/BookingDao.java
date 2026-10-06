package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BookingDao extends JpaRepository< BookingEntity,String> {
    @Query("""

            SELECT r.roomType, COUNT(r)
            FROM RoomEntity r
            WHERE r.isRoomAvailable = true
            AND r.hotel.hotelId = :hotelId
            GROUP BY r.roomType
       """)
    Map<String, Long> getCountByRoomType(String hotelId);

    @Query("""

           SELECT  r
           FROM RoomEntity r
           WHERE r.isRoomAvailable = true
           AND r.hotel.hotelId = :hotelId
           AND r.roomType =:roomtype
           """
    )

    List<RoomEntity> roomByHotelAndRoomType(String hotelId, String roomType);
}