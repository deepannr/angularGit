package com.spring.micro.service.currencyconversionservice.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.micro.service.currencyconversionservice.data.CurrencyConversion;
import com.spring.micro.service.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
@RequestMapping("/currency-conversion")
class CurrencyConversionApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy exchangeProxy;
	
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion conversion = exchangeProxy.retrieveExchangeValue(from, to);
		
		CurrencyConversion currency = new CurrencyConversion(conversion.getId(), from, to, conversion.getConversionMultiple(), quantity,
				quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
		
		logger.info("Currency Conversion: {}", currency);
		return currency;
	}

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		CurrencyConversion conversion = new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}/", CurrencyConversion.class,
						uriVariables)
				.getBody();

		CurrencyConversion currency = new CurrencyConversion(conversion.getId(), from, to, conversion.getConversionMultiple(), quantity,
				quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
		logger.info("Currency Conversion: {}", currency);
		return currency;
	}
}
