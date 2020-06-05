package com.spring.micro.service.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
//@PropertySources({@PropertySource("http://localhost:8888/limits-service-${env}.properties")})
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}
