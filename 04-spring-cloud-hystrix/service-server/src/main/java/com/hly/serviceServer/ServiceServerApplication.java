package com.hly.serviceServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceServerApplication.class, args);
	}
}
