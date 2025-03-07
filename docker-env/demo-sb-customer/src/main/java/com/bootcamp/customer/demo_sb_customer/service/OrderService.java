package com.bootcamp.customer.demo_sb_customer.service;

import java.util.List;

import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;

public interface OrderService {
  // 2 - get list
  List<OrderEntity> getOrders();

  // 1 - insert into
  OrderEntity createOrder(Long customerId, OrderEntity orderEntity);
  
}
