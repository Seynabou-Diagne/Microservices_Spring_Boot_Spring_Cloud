package com.esmt.m223isi.microservices.conversion.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyConversionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionMicroserviceApplication.class, args);
	}

}
