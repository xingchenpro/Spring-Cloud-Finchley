package com.javahly.stockservice.mapper;

import com.javahly.stockservice.entity.Stock;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface StockMapper {

    @Select("select * from stock")
    public List<Stock> getStocks();

   @Update("update stock set count=count-1 where id=#{id}")
    public int updateStock(Integer id);

}
