package com.spring.micro.service.limitsservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.service.limitsservice.conf.Configuration;
import com.spring.micro.service.limitsservice.data.Limits;

@RestController
@RequestMapping("/limits-service")
public class LimitsConfigurationApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/get")
	public Limits fetchLimits() {
		Limits limits = new Limits(config.getMaximum(), config.getMinumum());
		logger.info("Limits Logger: {}", limits);
		return limits;
	}
}
