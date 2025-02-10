package com.bootcamp.customer.demo_sb_customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;

public interface CustomerOperation {
  // @GetMapping(value = "/customer")
  // List<Customer> getCustomers();

  @GetMapping(value = "/customers")
  List<CustomerEntity> getCustomers();
  @PostMapping(value = "/customer")
  CustomerEntity createUser(@RequestBody CustomerEntity customerEntity);

  //1
  // @PostMapping(value = "/customer")
  // public Customer createCustomer(@RequestBody Customer customer);

  //2
  // @GetMapping(value = "/customer")
  // public List<Customer> getCustomers();

  //3
  // @GetMapping(value = "/customer")
  // public Customer getCustomer(@RequestParam String name);

  //4
  // @DeleteMapping(value = "/customer")
  // public Boolean deleteCustomer(@RequestParam char gender);

  //5
  // @PutMapping(value = "/customer")
  // public Boolean updateCustomer(@RequestParam String name, @RequestBody Customer customer);

  //6
  //find name, change age
  // @PatchMapping(value = "/customer/name/{name}")
  // public Boolean patchCustomerName(@RequestParam String name, @PathVariable int age);
  


  
}
