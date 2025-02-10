package com.bootcamp.customer.demo_sb_customer.service;

import java.util.List;

import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;

public interface CustomerService {
  //List<Customer> getCustomers();
  //Customer createCustomer(Customer customer);
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customereEntity);
  

}
