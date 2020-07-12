package com.oms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.exception.OrderNotFoundException;
import com.oms.model.OrderModel;
import com.oms.model.OrderRequestData;
import com.oms.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping("/orders")
	public OrderModel createOrder(@Valid @RequestBody OrderRequestData request) {
		return service.createOrder(request);
	}

	@GetMapping("/orders/{orderId}")
	public OrderModel getOrder(@PathVariable String orderId) {
		return service.getOrder(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found with order Id: " + orderId));
	}
}
