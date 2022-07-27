package com.sutanrrier.rabbitmqorderconsumer;

import java.io.Serializable;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double price;
	private Boolean isPaid;
	
	public Order() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}
	
}