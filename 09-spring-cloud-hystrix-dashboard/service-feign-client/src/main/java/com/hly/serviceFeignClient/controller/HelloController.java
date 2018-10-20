package com.hly.serviceFeignClient.controller;

import com.hly.serviceFeignClient.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/20
 */
@RestController
public class HelloController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    HelloService helloService;

    /**
     * 消费服务
     */

    @GetMapping(value = "/hello")
    public String Hello(@RequestParam String name){
        return helloService.HiServiceClient(name);
    }


}
