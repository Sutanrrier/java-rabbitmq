package com.sutanrrier.rabbitmqorderproducer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutanrrier.rabbitmqorderproducer.entities.Order;
import com.sutanrrier.rabbitmqorderproducer.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.insert(order));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Order> update(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(orderService.update(id));
	}
}
