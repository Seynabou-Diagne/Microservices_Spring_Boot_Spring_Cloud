package com.esmt.m223isi.microservices.conversion.microservice.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.esmt.m223isi.microservices.conversion.microservice.bean.CurrencyConversion;

@FeignClient(name="currency-exchange") 
//@FeignClient(name="currency-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy { 
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}") 
	public CurrencyConversion getCurrencyExchange ( @PathVariable String from, @PathVariable String to);
}
