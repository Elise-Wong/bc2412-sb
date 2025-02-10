package com.bootcamp.customer.demo_sb_customer.model;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
  //public static final List<Customer> CUSTOMER_DATABASE = new LinkedList<>();
  private String name;
  private int age;
  ///private char gender;
  
}
