package com.spring.micro.service.currencyexchangeservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.service.currencyexchangeservice.data.ExchangeValue;
import com.spring.micro.service.currencyexchangeservice.repo.ExchangeValueRepo;

@RestController
@RequestMapping("/currency-exchange")
class CurrencyExchangeApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepo repository;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue returnExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		logger.info("Currency Exchange: {}", exchangeValue);
		return exchangeValue;
	}
}
