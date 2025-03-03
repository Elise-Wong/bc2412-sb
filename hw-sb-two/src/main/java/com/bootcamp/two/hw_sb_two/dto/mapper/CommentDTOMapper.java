package com.bootcamp.two.hw_sb_two.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.two.hw_sb_two.dto.CommentDTO;

@Component
public class CommentDTOMapper {
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
