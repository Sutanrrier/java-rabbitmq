package com.sutanrrier.rabbitmqorderproducer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutanrrier.rabbitmqorderproducer.entities.Order;
import com.sutanrrier.rabbitmqorderproducer.repositories.OrderRepository;
import com.sutanrrier.rabbitmqorderproducer.utils.MQUtils;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public Order insert(Order order) {
		orderRepository.save(order);
		rabbitTemplate.convertAndSend(MQUtils.ORDER_QUEUE, order);
		
		return orderRepository.save(order);
	}
	
	public Order update(Long id) {
		Order order = orderRepository.findById(id).get();
		order.setIsPaid(true);
		rabbitTemplate.convertAndSend(MQUtils.ORDER_QUEUE, order);
		
		return orderRepository.save(order);
	}
}
