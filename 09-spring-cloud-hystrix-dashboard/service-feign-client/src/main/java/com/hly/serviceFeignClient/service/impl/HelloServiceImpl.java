package com.hly.serviceFeignClient.service.impl;

import com.hly.serviceFeignClient.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/20
 */
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String HiServiceClient(String name) {
        return "sorry，"+name+"this service is close";
    }
}
