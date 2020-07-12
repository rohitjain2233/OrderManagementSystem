package com.oms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oms.exception.ProductNotFoundException;
import com.oms.model.ItemModel;
import com.oms.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemService service;

	@PostMapping("/products")
	public ItemModel createItem(@Valid @RequestBody ItemModel model) {
		return service.createItem(model);
	}

	@GetMapping("/products/{productCode}")
	public ItemModel getItem(@PathVariable String productCode) {
		return service.getItem(productCode)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with Code " + productCode));
	}
}
