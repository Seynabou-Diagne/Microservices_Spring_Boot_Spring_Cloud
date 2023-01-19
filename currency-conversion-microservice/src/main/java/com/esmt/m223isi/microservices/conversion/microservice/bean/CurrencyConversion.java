package com.esmt.m223isi.microservices.conversion.microservice.bean;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public class CurrencyConversion {
	
	private long id;
	private String from;
	private String to; 
	private BigDecimal rateExchange;
	private BigDecimal amount;
	private BigDecimal calculateAmount;
	private String source;
	private String environemment;
	
	
	public CurrencyConversion() {}

	public CurrencyConversion(long id, String from, String to, BigDecimal rateExchange, BigDecimal amount,
			BigDecimal calculateAmount, String source, String environnement) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rateExchange = rateExchange;
		this.amount = amount;
		this.calculateAmount = calculateAmount;
		this.source = source;
		this.environemment = environnement;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getRateExchange() {
		return rateExchange;
	}
	public void setRateExchange(BigDecimal rateExchange) {
		this.rateExchange = rateExchange;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getCalculateAmount() {
		return calculateAmount;
	}
	public void setCalculateAmount(BigDecimal calculateAmount) {
		this.calculateAmount = calculateAmount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEnvironemment() {
		return environemment;
	}

	public void setEnvironemment(String environemment) {
		this.environemment = environemment;
	}

	
}
	
