package com.hly.serviceConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigClientApplication.class, args);
	}

	/**
	 * 访问:http://localhost:8762/hly
	 */
	@Value("${hly}")
	String hly;
	@RequestMapping(value = "/hly")
	public String hi(){
		return hly;
	}
}
