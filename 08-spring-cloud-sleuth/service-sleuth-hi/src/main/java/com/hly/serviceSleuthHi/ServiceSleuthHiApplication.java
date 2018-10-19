package com.hly.serviceSleuthHi;

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
public class ServiceSleuthHiApplication {

	/**
	 * 1.运行：java -jar zipkin-server-2.10.1-exec.jar ；
	 * 2.访问localhost：9411
	 * 3.依次启动工程 ；
	 * 4.访问：http://localhost:8988/hi
	 * 5.查看zipkin依赖分析
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceSleuthHiApplication.class, args);
	}


	private static final Logger LOG = Logger.getLogger(ServiceSleuthHiApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		LOG.log(Level.INFO, "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8989/hello", String.class);
	}

	@RequestMapping("/info")
	public String info(){
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}

	/**
	 * http://blog.didispace.com/spring-cloud-starter-dalston-8-6/
	 * 该信息是否要被后续的跟踪信息收集器获取和存储
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
