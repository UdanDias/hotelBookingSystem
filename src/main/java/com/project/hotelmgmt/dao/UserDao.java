package com.project.hotelmgmt.dao;

import com.project.hotelmgmt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,String> {
}
