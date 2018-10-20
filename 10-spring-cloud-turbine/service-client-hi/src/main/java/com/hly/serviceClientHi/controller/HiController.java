package com.hly.serviceClientHi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/20
 */
@RestController
public class HiController {

    @HystrixCommand(fallbackMethod="ServiceError")
    @RequestMapping("/hi")
    public String hi() {
        return "success...SERVICE-HI";
    }

    public String ServiceError() {
        return "SERVICE-HI HYSTRIX ERROR";
    }
}
