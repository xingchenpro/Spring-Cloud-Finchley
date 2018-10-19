package com.hly.serviceSleuthHello;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceSleuthHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSleuthHelloApplication.class, args);
	}
	private static final Logger LOG = Logger.getLogger(ServiceSleuthHelloApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hello")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace service-hello  ");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}

	@RequestMapping("/hi")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-hello ");
		return "i'm service-hello";

	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
