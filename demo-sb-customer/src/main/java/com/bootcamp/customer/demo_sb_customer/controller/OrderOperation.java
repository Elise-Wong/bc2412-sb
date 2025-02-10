package com.bootcamp.customer.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {

  //localhost:8100/order?cid=
  @PostMapping
  OrderEntity createOrder(@RequestParam (value = "cid") Long customerId, @RequestBody OrderEntity orderEntity);
  
}
