package com.bootcamp.customer.demo_sb_customer.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.codewave.SysCode;
import com.bootcamp.customer.demo_sb_customer.controller.OrderOperation;
import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.customer.demo_sb_customer.service.OrderService;

@RestController
public class OrderContollerImpl implements OrderOperation{ //base on OrderOperation , 所以跟哂佢
  @Autowired
  private OrderService orderService;

  // 2 - get list
  @Override
  public List<OrderEntity>getOrders(){
    return this.orderService.getOrders();
  }
  //ApiResp

  // 1 - insert into
  @Override //base on OrderOperation 
  //public OrderEntity createOrder(Long customerId, OrderEntity orderEntity){
  //  return this.orderService.createOrder(customerId, orderEntity);
  //}
  public ApiResp<OrderEntity> createOrder(Long customerId, OrderEntity orderEntity){  
    OrderEntity serviceResult = this.orderService.createOrder(customerId, orderEntity);
  
    return ApiResp.<OrderEntity>builder()
      .data(serviceResult)
      .syscode(SysCode.OK)
      .build();
  }

  
}
