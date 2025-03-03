package com.bootcamp.two.hw_sb_two.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.two.hw_sb_two.dto.CommentDTO;
import com.bootcamp.two.hw_sb_two.dto.PostDTO;
import com.bootcamp.two.hw_sb_two.dto.UserDTO;
import com.bootcamp.two.hw_sb_two.model.dto.PostDto;
import com.bootcamp.two.hw_sb_two.model.dto.UserDto;

@Component
public class UserDTOMapper {
  public UserDTO map(UserDto dto){
    //create object
    UserDTO.Address.Geo userAddressGeo = UserDTO.Address.Geo.builder()
      .latitude(dto.getAddress().getGeo().getLatitude())
      .longitude(dto.getAddress().getGeo().getLongitude())
      .build();

    //create object
    UserDTO.Address userAddress = UserDTO.Address.builder()
      .street(dto.getAddress().getStreet())
      .suite(dto.getAddress().getSuite())
      .city(dto.getAddress().getCity())
      .zipcode(dto.getAddress().getZipcode())
      .geo(userAddressGeo)
      .build();

    //create object
    UserDTO.Company userCompany = UserDTO.Company.builder()
      .name(dto.getCompany().getName())
      .catchPhrase(dto.getCompany().getCatchPhrase())
      .bs(dto.getCompany().getBs())
      .build();

    return UserDTO.builder()
      .id(dto.getId())
      .name(dto.getName())
      .username(dto.getUsername())
      .email(dto.getEmail())
      .address(userAddress)
      .phone(dto.getPhone())
      .website(dto.getWebsite())
      .company(userCompany)
      .build();

  }

  

  public PostDTO map(PostDto dto){

    //PostDTO userId = UserDTO.builder().id(dto.getId()).build();

    return PostDTO.builder()
      //.userId(userId)
      .postId(dto.getPostId())
      .title(dto.getTitle())
      .body(dto.getBody())
      .build();
  }

  public CommentDTO map(CommentDTO dto){
    return CommentDTO.builder()
      .postId(dto.getPostId())
      .id(dto.getId())
      .name(dto.getName())
      .email(dto.getEmail())
      .body(dto.getBody())
      .build();
  }

}
