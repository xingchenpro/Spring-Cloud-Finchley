package com.javahly.serviceblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableSwagger2
public class ServiceBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBlogApplication.class, args);
	}

}
