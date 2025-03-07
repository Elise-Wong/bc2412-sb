package com.bootcamp.customer.demo_sb_customer.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;

public interface CustomerService {
  //List<Customer> getCustomers();
  //Customer createCustomer(Customer customer);
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customereEntity);

  
  List<CustomerEntity> getCustomersByJPQL(String name);
  List<CustomerEntity> getCustomersByNQ(String name);
  

}
