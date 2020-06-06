package com.spring.micro.service.currencyexchangeservice.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.service.currencyexchangeservice.data.CONVERSION_CURRENCY;
import com.spring.micro.service.currencyexchangeservice.data.ExchangeValue;

@RestController
@RequestMapping("/currency-exchange")
class CurrencyExchangeApi {
	
	@Autowired
	private Environment env;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue returnExchangeValue(@PathVariable CONVERSION_CURRENCY from,
			@PathVariable CONVERSION_CURRENCY to) {
		ExchangeValue exchangeValue = new ExchangeValue(1, from, to, BigDecimal.valueOf(70));
		
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return exchangeValue;
	}
}
