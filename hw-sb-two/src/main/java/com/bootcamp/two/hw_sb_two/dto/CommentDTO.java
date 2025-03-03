package com.bootcamp.two.hw_sb_two.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommentDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;

  @OneToMany
  @JoinColumn(name = "userId")
  @Setter
  private UserDTO userDTO;

  @ManyToOne
  @JoinColumn(name = "postId")
  @Setter
  private PostDTO postDTO;

  

}
