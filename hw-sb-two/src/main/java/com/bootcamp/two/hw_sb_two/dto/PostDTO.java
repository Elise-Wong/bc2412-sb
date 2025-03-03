package com.bootcamp.two.hw_sb_two.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostDTO {
  //private Long userId;
  @JsonProperty(value = "id")
  private Long postId;
  private String title;
  private String body;

  @OneToMany(mappedBy = "postDTO")
  @JsonProperty(value = "comments")
  private List<CommentDTO> comments;
  //private List<CommentDTO> comments = new ArrayList<>();

}
