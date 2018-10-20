package com.hly.serviceclienthello.controller;

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
public class HelloController {

    @HystrixCommand(fallbackMethod="ServiceError")
    @RequestMapping("/hello")
    public String item() {
        return "success...SERVICE-HELLO";
    }

    public String ServiceError() {
        return "SERVICE-HELLO HYSTRIX ERROR";
    }
}
