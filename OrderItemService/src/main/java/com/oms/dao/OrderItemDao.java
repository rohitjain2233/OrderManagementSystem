package com.oms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.ItemModel;

@Repository
public interface OrderItemDao extends JpaRepository<ItemModel, String> {

}
