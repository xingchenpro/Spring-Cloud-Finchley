package com.myssm.service;

import com.myssm.model.User;

import java.util.List;

/**
 * Author:hly
 * time:18;4;5
 */
public interface UserService {
    List<User> selectAll();
    User selectUserByUserid(String userid);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);

}
