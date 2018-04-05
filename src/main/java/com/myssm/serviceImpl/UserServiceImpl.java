package com.myssm.serviceImpl;

import com.myssm.dao.UserDao;
import com.myssm.model.User;
import com.myssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User selectUserByUserid(String userid){
        return userDao.selectUserByUserid(userid);
    }

}
