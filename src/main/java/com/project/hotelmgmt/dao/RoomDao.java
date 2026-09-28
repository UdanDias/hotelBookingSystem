package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<RoomEntity,String> {
}
