package com.javahly.serviceblog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableSwagger2Doc
public class ServiceBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBlogApplication.class, args);
	}

}
