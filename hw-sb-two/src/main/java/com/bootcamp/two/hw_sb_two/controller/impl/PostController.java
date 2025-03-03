package com.bootcamp.two.hw_sb_two.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.two.hw_sb_two.controller.PostOperation;
import com.bootcamp.two.hw_sb_two.dto.PostDTO;
import com.bootcamp.two.hw_sb_two.dto.UserDTO;
import com.bootcamp.two.hw_sb_two.dto.mapper.PostDTOMapper;
import com.bootcamp.two.hw_sb_two.model.dto.PostDto;
import com.bootcamp.two.hw_sb_two.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class PostController implements PostOperation{
  @Autowired
  private PostService postService;
  @Autowired
  private PostDTOMapper postDTOMapper;

  // Task 2
  @GetMapping(value = "/posts")
  public List<PostDto> getPosts() {
      return this.postService.getPosts();
  }
  
  // Task 3 -test
  @GetMapping(value = "/posts/mapper")
  public List<PostDTO> getPostsComments() {
      return this.postService.getPosts().stream()
        .map(e -> postDTOMapper.map(e))
        .collect(Collectors.toList());
  }
  
}
