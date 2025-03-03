package com.bootcamp.two.hw_sb_two.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.two.hw_sb_two.dto.PostDTO;
import com.bootcamp.two.hw_sb_two.model.dto.PostDto;

@Component
public class PostDTOMapper {

  public PostDTO map(PostDto dto){

  //PostDTO userId = UserDTO.builder().id(dto.getId()).build();

  return PostDTO.builder()
    //.userId(userId)
    .userId(dto.getUserId())
    .postId(dto.getPostId())
    .title(dto.getTitle())
    .body(dto.getBody())
    .build();
  }
}
