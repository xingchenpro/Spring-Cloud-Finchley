package com.hly.serviceZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {
	/**
	 * 路由网关
	 * 访问：http://localhost:8769/api-a/hi?token=hly ; hi hly，I am from port: 8763
	 * 访问: http://localhost:8769/api-b/hello?token=hly ; hello hly,I am from port: 8762
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
