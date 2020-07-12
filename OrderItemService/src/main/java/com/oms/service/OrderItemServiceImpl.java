package com.oms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.dao.OrderItemDao;
import com.oms.model.ItemModel;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDao itemDao;
	
	@Override
	public ItemModel createItem(ItemModel model) {
		return itemDao.save(model);
	}

	@Override
	public Optional<ItemModel> getItem(String productCode) {
		return itemDao.findById(productCode);
	}
}
