package com.bootcamp.customer.demo_sb_customer.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.controller.CustomerOperation;
import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;
import com.bootcamp.customer.demo_sb_customer.service.CustomerService;

@RestController
public class CustomerControllerImpl implements CustomerOperation{
  @Autowired
  private CustomerService customerService;

 // @Override
  //public List<Customer> getCustomers(){
  //  return this.customerService.getCustomers();
  //}
  @Override
  public List<CustomerEntity> getCustomers(){
    return this.customerService.getCustomers();
  }

  @Override
  public CustomerEntity createUser(CustomerEntity customerEntity) {
    return this.customerService.createCustomer(customerEntity);
  }


  //1
  // public Customer createCustomer(Customer customer){

  // }

  //2
  // public List<Customer> getCustomers(){}

  //3
  // public Customer getCustomer(String name){}

  //4
  // public Boolean deleteCustomer(char gender){}

  //5
  // public Boolean updateCustomer(String name, Customer customer){}

  //6
  //find name, change age
  // public Boolean patchCustomerName(String name, int age){
  //   return
  // }
  
}
