package com.bootcamp.customer.demo_sb_customer.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.controller.UserOperation;
import com.bootcamp.customer.demo_sb_customer.dto.UserDTO;
import com.bootcamp.customer.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;
import com.bootcamp.customer.demo_sb_customer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserControllerImpl implements UserOperation {
  @Autowired
  private UserService userService;
  @Autowired
  private UserDTOMapper userDTOMapper;

  @GetMapping(value = "/users")
  //public List<UserDto> getUsers(){
    //return this.userService.getUsers();

 // List sof UserDto -> List of UserDTO
 // object 內 object
  public List<UserDTO> getUsers(){
    return this.userService.getUser().stream()
      .map(e -> userDTOMapper.map(e))
      .collect(Collectors.toList());

    // List<UserDto> serviceResults = this.userService.getUsers();
    // List<UserDTO> userDTOs = new ArrayList<>();
    // for (UserDto dto : serviceResults){
    //   UserDTO userDTO = userDTOMapper.map(dto);

    //   // add the new DTO to List
    //   userDTOs.add(userDTO);
    // }
    // return userDTOs;

  }
}
