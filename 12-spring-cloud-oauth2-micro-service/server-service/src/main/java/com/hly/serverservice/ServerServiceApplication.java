package com.hly.serverservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerServiceApplication.class, args);
	}
}
