package com.hly.serviceFeignHystrix.controller;

import com.hly.serviceFeignHystrix.service.HiHystrixService;
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
public class HiController {

   @Autowired
   HiHystrixService hiHystrixService;

    /**
     * 消费服务
     * @param name
     * @return
     */
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return hiHystrixService.sayHiFromClientOne( name );
    }
}
