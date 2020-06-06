package com.spring.micro.service.currencyexchangeservice.data;

import java.math.BigDecimal;

public class ExchangeValue {
	private int id;

	private CONVERSION_CURRENCY from;

	private CONVERSION_CURRENCY to;

	private BigDecimal conversionMultiple;
	
	private int port;

	public ExchangeValue() {
		// Do Nothing
	}

	public ExchangeValue(int id, CONVERSION_CURRENCY from, CONVERSION_CURRENCY to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CONVERSION_CURRENCY getFrom() {
		return from;
	}

	public void setFrom(CONVERSION_CURRENCY from) {
		this.from = from;
	}

	public CONVERSION_CURRENCY getTo() {
		return to;
	}

	public void setTo(CONVERSION_CURRENCY to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
