package com.hly.springCloudOAuth.dao;


import com.hly.springCloudOAuth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
