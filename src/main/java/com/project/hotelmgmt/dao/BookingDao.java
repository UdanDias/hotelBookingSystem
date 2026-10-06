package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookingDao extends JpaRepository< BookingEntity,String> {
    @Query("SELECT r.roomType, COUNT(r) from RoomEntity r WHERE r.isRoomAvailable =true GROUP BY r.roomType")
    Map<String,Long> getCountByRoomType();

    @Query("""
    SELECT r.roomType, COUNT(r)
    FROM RoomEntity r
    WHERE r.isRoomAvailable = true
    AND r.hotel.hotelId = :hotelId
    GROUP BY r.roomType
""")
    Map<String, Long> getCountByRoomTypeByHotel(@Param("hotelId") String hotelId);
}
