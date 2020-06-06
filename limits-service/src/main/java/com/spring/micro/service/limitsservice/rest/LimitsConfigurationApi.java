package com.spring.micro.service.limitsservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.micro.service.limitsservice.conf.Configuration;
import com.spring.micro.service.limitsservice.data.Limits;

@RestController
@RequestMapping("/limits-service")
public class LimitsConfigurationApi {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/get")
	public Limits fetchLimits() {
		return new Limits(config.getMaximum(), config.getMinumum());
	}
}
