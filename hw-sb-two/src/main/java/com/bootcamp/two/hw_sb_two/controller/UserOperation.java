package com.bootcamp.two.hw_sb_two.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.two.hw_sb_two.dto.UserCommentDTO;
import com.bootcamp.two.hw_sb_two.model.dto.UserDto;

public interface UserOperation {
  // Task 2
  @GetMapping(value = "/users")
  List<UserDto> getUsers(); //getJPHUsers

  // Task 3b
  @GetMapping(value = "/users/xx")
  List<UserCommentDTO> getUserComments(@RequestParam String userId);

  

  

  
}
