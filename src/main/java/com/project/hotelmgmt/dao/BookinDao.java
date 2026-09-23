package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface BookinDao extends JpaRepository< BookingEntity,String> {
}
