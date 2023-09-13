package org.demo.cop.priceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.demo.cop.priceservice"})
public class PriceServiceApplication {

	//server.port to set the port - default = 8080
	public static void main(String[] args) {
		SpringApplication.run(PriceServiceApplication.class, args);
	}

}
