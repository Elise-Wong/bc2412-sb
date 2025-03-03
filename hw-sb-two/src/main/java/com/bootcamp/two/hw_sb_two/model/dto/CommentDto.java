package com.bootcamp.two.hw_sb_two.model.dto;

import lombok.Getter;

@Getter
public class CommentDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
  
}
