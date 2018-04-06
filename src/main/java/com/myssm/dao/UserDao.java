package com.myssm.dao;

/**
 * Author:hly
 * time:18;4;5
 */

import com.myssm.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service("userService")注解是告诉Spring，当Spring要创建UserServiceImpl的的实例时， bean的名字必须叫做"userService"，这样当Action需要使用UserServiceImpl的的实例时,就可以由Spring创建好的"userService"，
 * 然后注入给Action。
 */
@Service(value = "userDao")
public interface UserDao {
    List<User> selectAll();
    User selectUserByUserid(String userid);
    boolean insert(User user);

    boolean update(User user);

    boolean delete(String userid);
}
