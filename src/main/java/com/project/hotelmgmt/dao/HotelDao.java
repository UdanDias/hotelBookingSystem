package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository<HotelEntity,String> {
}
