package com.hly.eurekaclientribbon.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/16
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        //调用该方法，做了负载均衡，访问不同端口的实例
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name="+name,String.class);
    }

    /**
     * 启动两个服务，关闭一个，只能访问另一个，两个都关闭，将输出以下语句
     * @param name
     * @return
     */
    public String helloError(String name){
        return "hello,"+name+",sorry,error";
    }

}
