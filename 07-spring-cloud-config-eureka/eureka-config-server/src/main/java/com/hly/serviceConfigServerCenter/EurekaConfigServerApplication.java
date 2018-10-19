package com.hly.serviceConfigServerCenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigServerApplication {

	/**
	 * 此服务将服务配置中心作为一个微服务
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServerApplication.class, args);
	}
}
