package com.bootcamp.two.hw_sb_two.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class PostDto {
  private Long userId;  //id
  @JsonProperty(value = "id")
  private Long postId;  //userId
  private String title;
  private String body;
  
}
