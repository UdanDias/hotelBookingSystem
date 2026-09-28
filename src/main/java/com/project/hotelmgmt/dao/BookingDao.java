package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository< BookingEntity,String> {
}
