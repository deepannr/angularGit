package com.spring.micro.service.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.micro.service.currencyexchangeservice.data.ExchangeValue;

public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Integer> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
