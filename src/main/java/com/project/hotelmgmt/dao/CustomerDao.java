package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
