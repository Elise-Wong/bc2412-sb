package com.bootcamp.customer.demo_sb_customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {

  //localhost:8100/order?cid=

  // 2 - get list
  @GetMapping(value = "/orders")
  @ResponseStatus(HttpStatus.OK) //200
  List<OrderEntity> getOrders();

  // 1 - insert into
  @PostMapping(value = "/order")
  @ResponseStatus(HttpStatus.CREATED) //201
  //OrderEntity createOrder(@RequestParam (value = "cid") Long customerId, @RequestBody OrderEntity orderEntity);
  ApiResp<OrderEntity> createOrder(@RequestParam (value = "cid") Long customerId, @RequestBody OrderEntity orderEntity);
  
}
