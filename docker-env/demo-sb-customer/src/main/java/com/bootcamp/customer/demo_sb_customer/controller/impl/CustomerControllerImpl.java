package com.bootcamp.customer.demo_sb_customer.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.codewave.SysCode;
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
  //public List<CustomerEntity> getCustomers(){
  //  return this.customerService.getCustomers();
  //}
  public ApiResp<List<CustomerEntity>> getCustomers(){
    List<CustomerEntity> customerEntities = this.customerService.getCustomers();
    return ApiResp.<List<CustomerEntity>>builder()
      .syscode(SysCode.OK)
      .data(customerEntities)
      .build();
  }


  @Override
  //public CustomerEntity createCustomer(CustomerEntity customerEntity) {
  //  return this.customerService.createCustomer(customerEntity);
  //}
  public ApiResp<CustomerEntity> createCustomer(CustomerEntity customerEntity) {
    CustomerEntity serviceResult = 
      this.customerService.createCustomer(customerEntity);
    return ApiResp.<CustomerEntity>builder()
      .syscode(SysCode.OK)
      .data(serviceResult)
      .build();
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

  //JPQL
  @Override
  public List<CustomerEntity> getCustomerByJPQL(@RequestParam String name){
    return this.customerService.getCustomersByJPQL(name);
  }
  
  //Native
  @Override
  public List<CustomerEntity> getCustomerByNQ(@RequestParam String name){
    return this.customerService.getCustomersByNQ(name);
  }
  
}
