package com.spring.micro.service.limitsservice.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	private int maximum;
	
	private int minumum;

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinumum() {
		return minumum;
	}

	public void setMinumum(int minumum) {
		this.minumum = minumum;
	}
}