package com.bootcamp.two.hw_sb_two.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.bootcamp.two.hw_sb_two.model.dto.CommentDto;

public interface CommentOperation {
  @GetMapping(value = "/comments")
  List<CommentDto> getComments();

  
}
