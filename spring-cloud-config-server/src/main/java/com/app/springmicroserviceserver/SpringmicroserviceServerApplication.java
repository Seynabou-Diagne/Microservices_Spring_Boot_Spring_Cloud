package com.app.springmicroserviceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringmicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmicroserviceServerApplication.class, args);
	}

}
