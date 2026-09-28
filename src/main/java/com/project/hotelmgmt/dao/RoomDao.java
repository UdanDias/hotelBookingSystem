package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import com.project.hotelmgmt.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomDao extends JpaRepository<RoomEntity,String> {
//    @Query("""
//    SELECT b
//    FROM BookingEntity b
//    WHERE b.bookingID IN (
//        SELECT b2.bookingID
//        FROM BookingEntity b2
//        JOIN b2.rooms r
//        WHERE r.roomId = :roomId
//    )
//""")
//    List<BookingEntity> getBookingsByRoomID(@Param("roomId") String roomId);
}
