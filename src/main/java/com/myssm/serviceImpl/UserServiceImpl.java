package com.myssm.serviceImpl;

import com.myssm.dao.UserDao;
import com.myssm.model.User;
import com.myssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hly
 * @date 18:4:5
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public List<User> selectAll(int page, int pageSize) {
        return userDao.selectAll(page, pageSize);
    }

    @Override
    public User selectUserByUserid(String userid){
        return userDao.selectUserByUserid(userid);
    }
    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(String userid) {
        return userDao.delete(userid);
    }

}
