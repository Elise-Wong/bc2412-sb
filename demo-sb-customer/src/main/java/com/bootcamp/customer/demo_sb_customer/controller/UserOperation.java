package com.bootcamp.customer.demo_sb_customer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.customer.demo_sb_customer.dto.UserDTO;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;

public interface UserOperation {
  @GetMapping(value = "/users")
  List<UserDTO>getUsers();
  

  
}
