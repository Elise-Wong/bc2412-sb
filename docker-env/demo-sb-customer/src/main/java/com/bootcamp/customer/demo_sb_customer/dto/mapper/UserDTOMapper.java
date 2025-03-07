package com.bootcamp.customer.demo_sb_customer.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.customer.demo_sb_customer.dto.UserDTO;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;

@Component // become bean
public class UserDTOMapper {
  //input to output
  //instance method
  public UserDTO map(UserDto dto){ //after become bean, no more static
      //create object
      UserDTO.Address.Geo userAddressGeo =  UserDTO.Address.Geo.builder()
        .latitude(dto.getAddress().getGeo().getLatitude())
        .longitude(dto.getAddress().getGeo().getLongitude())
        .build();
      //create object
      UserDTO.Address userAddress = UserDTO.Address.builder()
        .city(dto.getAddress().getCity())
        .street(dto.getAddress().getStreet())
        .suite(dto.getAddress().getSuite())
        .geo(userAddressGeo)
        .build();
      ////create object
      return UserDTO.builder()
        .id(dto.getId())
        .name(dto.getName())
        .email(dto.getEmail())
        .username(dto.getUsername())
        .address(userAddress)
        .build();
  }
}
