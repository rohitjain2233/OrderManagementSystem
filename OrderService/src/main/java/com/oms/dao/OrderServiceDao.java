package com.oms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.OrderModel;

@Repository
public interface OrderServiceDao extends JpaRepository<OrderModel, Integer>{

}
