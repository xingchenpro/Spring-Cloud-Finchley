package com.javahly.orderservice.web;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.javahly.orderservice.entity.Order;
import com.javahly.orderservice.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/10
 * @QQ :1136513099
 * @desc :
 */
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderMapper indexMapper;

    @RequestMapping(value = "/orders")
    public List<Order> getUsers() {
        return indexMapper.getOrders();
    }

    @RequestMapping(value = "/order/{goodsId}")
    @Transactional
    @LcnTransaction
    public List<Order> addUser(@PathVariable("goodsId")Integer id) {
        indexMapper.addOrder(id);
        //添加订单，调用库存减库存
        restTemplate.getForObject("http://localhost:8883/stock/"+id, String.class);
        int a = 1/0;
        return indexMapper.getOrders();
    }
}
