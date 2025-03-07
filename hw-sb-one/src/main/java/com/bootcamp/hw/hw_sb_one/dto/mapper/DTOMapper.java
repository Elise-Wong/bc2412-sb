package com.bootcamp.hw.hw_sb_one.dto.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.hw.hw_sb_one.dto.CalReqDTO;
import com.bootcamp.hw.hw_sb_one.dto.CalRespDTO;
import com.bootcamp.hw.hw_sb_one.model.Operation;

@Component
public class DTOMapper {
  public CalRespDTO map(Integer x, Integer y, Operation operation, Integer result){ //CalReqDTO reqDto
    return CalRespDTO.builder()
      .x(String.valueOf(x)) //.x(reqDto.getX())
      .y(String.valueOf(y))
      .operation(reqDto)
      .result(String.valueOf(result))
      .build();
  }
}
