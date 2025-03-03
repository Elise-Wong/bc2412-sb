package com.bootcamp.two.hw_sb_two.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserCommentDTO {
  private Long id;
  private String username;
  @JsonProperty(value = "comments")
  private List<CommentDTO> commentDTOs;

  //
  public static class CommentDTO{
    private String name;
    private String email;
    private String body;
  }
}
