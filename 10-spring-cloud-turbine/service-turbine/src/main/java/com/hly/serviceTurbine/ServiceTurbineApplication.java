package com.hly.serviceTurbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class ServiceTurbineApplication {

	/**
	 * 1.依次启动 service-server,service-client-hi,service-client-hello,service-turbine
	 * 2.访问：http://localhost:8764/turbine.stream
	 * 3.访问：http://localhost:8762/hi
	 * 4.访问：http://localhost:8762/hello
	 * 5.访问：http://localhost:8763/hystrix
	 * 6.在界面上输入监控流：http://localhost:8764/turbine.stream
	 * 7.点击monitor看到监控界面
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineApplication.class, args);
	}
}
