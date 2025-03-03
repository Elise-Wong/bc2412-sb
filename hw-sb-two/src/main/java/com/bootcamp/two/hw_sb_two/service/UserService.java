package com.bootcamp.two.hw_sb_two.service;

import java.util.List;

import com.bootcamp.two.hw_sb_two.model.dto.UserDto;

public interface UserService { //JPHService
  List<UserDto> getUsers();
}
