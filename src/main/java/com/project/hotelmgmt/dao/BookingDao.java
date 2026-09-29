package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface BookingDao extends JpaRepository< BookingEntity,String> {
    @Query("SELECT r.roomType, COUNT(r) from RoomEntity r GROUP BY r.roomType")
    Map<String,Integer> getCountByRoomType();
}
