package com.hly.serviceClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}

	/**
	 * 访问：http://localhost:8762/hello?name=hly
	 */
	@Value("${server.port}")
	String port;
	@RequestMapping("/hello")
	public String home(@RequestParam(value = "name",defaultValue = "hly")String name){
		return "hello "+name+",I am from port :"+port;
	}

}
