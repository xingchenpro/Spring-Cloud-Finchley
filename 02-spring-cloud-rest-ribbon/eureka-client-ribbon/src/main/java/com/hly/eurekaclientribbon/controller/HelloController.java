package com.hly.eurekaclientribbon.controller;

import com.hly.eurekaclientribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/16
 */

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    /**
     * 启动多个集群，浏览器多次访问 http://localhost:8764/hi?name=hly，交替出现结果
     * @param name
     * @return
     */
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}