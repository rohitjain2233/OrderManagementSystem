package com.oms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oms.model.OrderModel;
import com.oms.model.OrderRequestData;

@Service
public interface OrderService {
	OrderModel createOrder(OrderRequestData request);

	Optional<OrderModel> getOrder(String orderId);
}
