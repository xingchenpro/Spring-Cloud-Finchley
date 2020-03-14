package com.javahly;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTransactionManagerServer
public class TxlcnTmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxlcnTmServiceApplication.class, args);
	}

}
