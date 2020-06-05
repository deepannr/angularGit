package com.spring.micro.service.limitsservice.data;

public class Limits {
	private int maximum;
	
	private int minimum;
	
	protected Limits() {
		// Do Nothing
	}
	
	public Limits(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
