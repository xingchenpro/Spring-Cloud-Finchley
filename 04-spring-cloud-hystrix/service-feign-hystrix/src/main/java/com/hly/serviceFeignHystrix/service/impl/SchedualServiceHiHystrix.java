package com.hly.serviceFeignHystrix.service.impl;

import com.hly.serviceFeignHystrix.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/17
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}