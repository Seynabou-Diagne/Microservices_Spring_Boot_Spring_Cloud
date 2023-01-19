package com.esmt.m223isi.microservices.currencyexchangemicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmt.m223isi.microservices.currencyexchangemicroservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo (String from, String to);
}
