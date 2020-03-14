package com.javahly.orderservice.mapper;

import com.javahly.orderservice.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/11
 * @QQ :1136513099
 * @desc :
 */
@Repository
public interface OrderMapper {

    @Select("select * from `order`")
    public List<Order> getOrders();

    @Insert("insert into `order`(goodsId) values(#{id})")
    public int addOrder(Integer id);

}
