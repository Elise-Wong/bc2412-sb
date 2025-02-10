package com.bootcamp.customer.demo_sb_customer.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.customer.demo_sb_customer.service.OrderService;
import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.customer.demo_sb_customer.exception.BusinessException;
import com.bootcamp.customer.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.customer.demo_sb_customer.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CustomerRepository customerRepository;

  // if customer id not found , throw new BusinessException("Customer ID not found."), JSON都會見到
  //only happy flow (1句寫完)
  @Override
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity){
    CustomerEntity customerEntity = this.customerRepository.findById(customerId)
      .orElseThrow(() -> new BusinessException("Customer ID not found."));

    orderEntity.setCustomerEntity(customerEntity);
    // save orderEntity to Database
    return this.orderRepository.save(orderEntity);
    

// throw 左出去先, 因為有globalExceptionHandler


    // Optional<CustomerEntity> customerEntity = this.customerRepository.findById(customerId);
    // if (customerEntity.isPresent()){ //化解它
    //   orderEntity.setCustomerEntity(customerEntity.get());
    //   return orderEntity;
    // }
    // return xxxx;
  }

  
}
