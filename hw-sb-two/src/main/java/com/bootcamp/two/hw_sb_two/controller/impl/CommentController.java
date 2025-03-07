package com.bootcamp.two.hw_sb_two.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.two.hw_sb_two.controller.CommentOperation;
import com.bootcamp.two.hw_sb_two.dto.CommentDTO;

import com.bootcamp.two.hw_sb_two.dto.mapper.CommentDTOMapper;
import com.bootcamp.two.hw_sb_two.model.dto.CommentDto;
import com.bootcamp.two.hw_sb_two.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class CommentController implements CommentOperation{
  @Autowired
  private CommentService commentService;
  @Autowired
  private CommentDTOMapper commentDTOMapper;
  
  // Task 2
  @GetMapping(value = "/comments")
  public List<CommentDto> getComments() {
      return this.commentService.getComments();
  }
  
  // Task 3 -test
  // @GetMapping(value = "/comments/mapper")
  // public List<CommentDTO> getCComments() {
  //     return this.commentService.getComments().stream()
  //       .map(e -> commentDTOMapper.map(e))
  //       .collect(Collectors.toList());
  // }

  
}
