package com.bootcamp.customer.demo_sb_customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.model.Customer;

public interface CustomerOperation {
  // @GetMapping(value = "/customer")
  // List<Customer> getCustomers();

  @GetMapping(value = "/customers")
  @ResponseStatus(HttpStatus.OK) // 200
  //List<CustomerEntity> getCustomers();
  ApiResp<List<CustomerEntity>> getCustomers();

  @PostMapping(value = "/customer")
  @ResponseStatus(HttpStatus.CREATED) // 201
  //CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity);
  ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity);

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
  
  //JPQL
  @GetMapping(value = "/jpql/customers")
  @ResponseStatus(HttpStatus.OK)
  List<CustomerEntity> getCustomerByJPQL(@RequestParam String name);
  
  //Native
  @GetMapping(value = "/nq/customers") //native is key word, cant use
  @ResponseStatus(HttpStatus.OK)
  List<CustomerEntity> getCustomerByNQ(@RequestParam String name);

  
}
