package com.hly.oauthservice.dao;


import com.hly.oauthservice.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/28
 */

@Repository
public interface UserDao {

    //通过用户名查询用户
    public User findUserByUsername(String username);

}
