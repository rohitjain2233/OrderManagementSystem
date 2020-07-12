package com.oms.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oms.model.ItemModel;

@Service
public interface OrderItemService {
	ItemModel createItem(ItemModel model);
	Optional<ItemModel> getItem(String productCode);
}
