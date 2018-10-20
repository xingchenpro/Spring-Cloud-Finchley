package com.hly.serviceFeignClient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/20
 */
@FeignClient(value = "SERVICE-CLIENT",fallback = com.hly.serviceFeignClient.service.impl.HelloServiceImpl.class)
public interface HelloService {

    //这里的映射名和需要调用的服务的映射名一样
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String HiServiceClient(@RequestParam(value = "name")String name);

}
