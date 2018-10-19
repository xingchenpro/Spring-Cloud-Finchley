package com.hly.eurekaclientribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class EurekaClientRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientRibbonApplication.class, args);
	}
	@Bean
	//表明这个restRemplate开启负载均衡的功能
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
