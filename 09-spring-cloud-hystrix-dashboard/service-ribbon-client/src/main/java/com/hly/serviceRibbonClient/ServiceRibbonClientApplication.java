package com.hly.serviceRibbonClient;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//向服务中心注册
@EnableHystrix//开启Hystrix的使用。
@RestController
@EnableCircuitBreaker//开启Hystrix的使用。,声明这个主方法已经引入了断路器的注解，可以使用断路器了。
@EnableHystrixDashboard//开启监控熔断器
public class ServiceRibbonClientApplication {

	/**
	 * 1.访问：http://localhost:8764/hello?name=123 ； 负载均衡的提供方要去消费服务，即访问负载均衡服务器，去调用客户端
	 * 2.访问：http://localhost:8764/hystrix.stream ；显示数据指标
	 * 3.访问:http://localhost:8764/hystrix ;输入：http://localhost:8764/hystrix.stream ; 监控界面图形数据展示
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonClientApplication.class, args);
	}

	@Bean
	//@LoadBalanced:方法开启负载均衡功能
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	//springboot 版本如果是2.0则需要添加 ServletRegistrationBean 因为springboot的默认路径不是 "/hystrix.stream"
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
