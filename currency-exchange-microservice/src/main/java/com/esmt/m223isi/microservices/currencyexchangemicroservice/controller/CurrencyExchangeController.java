package com.esmt.m223isi.microservices.currencyexchangemicroservice.controller;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esmt.m223isi.microservices.currencyexchangemicroservice.bean.CurrencyExchange;
import com.esmt.m223isi.microservices.currencyexchangemicroservice.repository.CurrencyExchangeRepository;



@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange ( 
			@PathVariable String from, @PathVariable String to) {
			//return new CurrencyExchange (1001L, from, to, BigDecimal.valueOf(609.5));
		
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange==null)
			throw new RuntimeException ("Taux de change non trouvé pour"+from+"->"+to);
		return currencyExchange;
	}
			
			
	
}
