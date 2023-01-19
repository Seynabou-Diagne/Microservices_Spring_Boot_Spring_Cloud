package com.esmt.m223isi.microservices.conversion.microservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esmt.m223isi.microservices.conversion.microservice.bean.CurrencyConversion;
import com.esmt.m223isi.microservices.conversion.microservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@Autowired
	private Environment environnement;
	
	@GetMapping("/currency-conversion1/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion getCurrencyConversion1 ( 
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
		
			//return new CurrencyConversion (1001L, from, to, amount,BigDecimal.TEN, BigDecimal.TEN.multiply(amount));
		HashMap<String, String> uriVariables = new HashMap<>(); 
		uriVariables.put("from", from); uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().
				getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		String source = "Rest Template";
		currencyConversion.setSource(source);
		String port = environnement.getProperty("local.server.port");
	return new CurrencyConversion (currencyConversion.getId(),
	from, to, amount, currencyConversion.getRateExchange(), amount.multiply (currencyConversion.getRateExchange()), currencyConversion.getSource(), port);

	}
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion getCurrencyConversion ( 
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
			CurrencyConversion currencyConversion = proxy.getCurrencyExchange(from, to);
			String source = "Rest Template";
			currencyConversion.setSource(source);
			String port = environnement.getProperty("local.server.port");
			return new CurrencyConversion (currencyConversion.getId(),
			from, to, amount, currencyConversion.getRateExchange(), amount.multiply (currencyConversion.getRateExchange()), currencyConversion.getSource(), port );

	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversion getCurrencyConversionFeign ( 
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
			String source = "Feign Rest Client";
			CurrencyConversion currencyConversion = proxy.getCurrencyExchange(from, to);
			
			currencyConversion.setSource(source);
			
			String port = environnement.getProperty("local.server.port");;
			return new CurrencyConversion (currencyConversion.getId(),
			from, to, amount, currencyConversion.getRateExchange(), amount.multiply (currencyConversion.getRateExchange()), currencyConversion.getSource(), port );

	}
		
	
}
