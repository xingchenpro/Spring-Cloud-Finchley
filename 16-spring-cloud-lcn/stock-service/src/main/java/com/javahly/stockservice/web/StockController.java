package com.javahly.stockservice.web;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.javahly.stockservice.entity.Stock;
import com.javahly.stockservice.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class StockController {


    @Autowired
    StockMapper stockMapper;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/stocks")
    public List<Stock> getArticles() {
        return stockMapper.getStocks();
    }

    @RequestMapping(value = "/stock/{id}")
    @Transactional
    @LcnTransaction //分布式事务注解
    public List<Stock> addUser(@PathVariable("id") Integer id) {
        stockMapper.updateStock(id);
        return stockMapper.getStocks();
    }
}
