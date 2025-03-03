package com.bootcamp.two.hw_sb_two.service;

import java.util.List;

import com.bootcamp.two.hw_sb_two.model.dto.CommentDto;

public interface CommentService {
  List<CommentDto> getComments();
}
