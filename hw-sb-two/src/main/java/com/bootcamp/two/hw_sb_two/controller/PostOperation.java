package com.bootcamp.two.hw_sb_two.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.two.hw_sb_two.model.dto.PostDto;

public interface PostOperation {
  @GetMapping(value = "/posts")
  List<PostDto> getPosts();

  
}
