package com.oms.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.dao.OrderServiceDao;
import com.oms.exception.ProductNotFoundException;
import com.oms.model.Item;
import com.oms.model.ItemResponse;
import com.oms.model.OrderModel;
import com.oms.model.OrderRequestData;
import com.oms.proxy.OrderItemServiceProxy;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderItemServiceProxy proxy;
	@Autowired
	private OrderServiceDao orderDao;

	@Override
	public OrderModel createOrder(OrderRequestData request) {
		OrderModel model = new OrderModel();
		model.setCustomerFirstName(request.getCustomerFirstName());
		model.setCustomerLastName(request.getCustomerLastName());
		model.setEmail(request.getEmail());
		model.setOrderDate(LocalDateTime.now());
		model.setShippingAddress(request.getShippingAddress());
		HashMap<String, Integer> items = new HashMap<>();
		double totalPrice = 0;
		for (Item item : request.getItemList()) {
			try {
				ItemResponse product = proxy.getProduct(item.getProductCode());
				items.put(product.getProductCode(), item.getQuantity());
				totalPrice = totalPrice + item.getQuantity() * product.getPrice();
			} catch (Exception e) {
				throw new ProductNotFoundException("Product not found with Code " + item.getProductCode());
			}
		}
		model.setItems(items);
		model.setTotal(totalPrice);
		return orderDao.save(model);
	}

	@Override
	public Optional<OrderModel> getOrder(String orderId) {
		return orderDao.findById(Integer.parseInt(orderId));
	}
}
