package com.oms.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oms.model.ItemResponse;

@FeignClient(name = "order-item-service",url = "http://localhost:8200")
public interface OrderItemServiceProxy {
	@GetMapping("/product/{productCode}")
	public ItemResponse getProduct(@PathVariable("productCode") String item);
}
