package com.bootcamp.customer.demo_sb_customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;
import com.bootcamp.customer.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.customer.demo_sb_customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
  @Autowired
  private CustomerRepository customerRepository;

  
  //@Override
  //public List<Customer> getCustomers(){
  //  return Customer.CUSTOMER_DATABASE;
  //}

  // @Override
  // public Customer createCustomer(Customer customer){
  //   if (Customer.CUSTOMER_DATABASE.add(customer))
  //     return customer;
  //   return null;
  // }

  @Override
  public List<CustomerEntity> getCustomers(){
    return this.customerRepository.findAll(); // john 20, mary 40
  }

  @Override
  public CustomerEntity createCustomer(CustomerEntity customerEntity){
    return this.customerRepository.save(customerEntity);
  }
  

  @Override
  public List<CustomerEntity> getCustomersByJPQL(String customerName){
    return this.customerRepository.findByNameByJPQL(customerName);
  }

  @Override
  public List<CustomerEntity> getCustomersByNQ(String customerName){
    return this.customerRepository.findByNameByNativeSQL(customerName);
  }
}
