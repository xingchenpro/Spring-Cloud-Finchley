package com.hly.serviceConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ServiceConfigServerApplication {

	/**
	 * 服务配置中心
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceConfigServerApplication.class, args);
	}
}
