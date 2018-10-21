package com.hly.eurekaFeign.service;


import com.hly.eurekaFeign.service.impl.ServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/16
 */
//服务名指定调用哪个服务
@FeignClient(value = "eureka-client",fallback = ServiceHiHystrix.class)
public interface SchedualServiceHi {
    //这里的映射名和需要调用的服务的映射名一样
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
