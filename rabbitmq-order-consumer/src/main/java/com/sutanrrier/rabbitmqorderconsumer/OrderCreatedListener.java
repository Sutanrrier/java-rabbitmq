package com.sutanrrier.rabbitmqorderconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

	private final String QUEUE_NAME = "order.v1.order_created";
	
	@RabbitListener(queues = QUEUE_NAME)
	public void onOrderCreated(Order order) { 
		System.out.println("\nCARREGANDO PEDIDO DE ID " + order.getId() 
		+ "\nPreço do Pedido: " + order.getPrice()
		+ "\nStatus do Pedido: " + ((order.getIsPaid() == true) ? "PAGO" : "PROCESSANDO"));
	}
}
