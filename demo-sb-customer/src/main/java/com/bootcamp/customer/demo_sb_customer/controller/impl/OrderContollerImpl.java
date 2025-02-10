package com.bootcamp.customer.demo_sb_customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.controller.OrderOperation;
import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.customer.demo_sb_customer.service.OrderService;

@RestController
public class OrderContollerImpl implements OrderOperation{ //base on OrderOperation , 所以跟哂佢
  @Autowired
  private OrderService orderService;

  @Override //base on OrderOperation 
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity){
    return this.orderService.createOrder(customerId, orderEntity);
  }
  
}
