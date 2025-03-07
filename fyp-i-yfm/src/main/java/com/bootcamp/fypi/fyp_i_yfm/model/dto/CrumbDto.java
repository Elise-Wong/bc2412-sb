package com.bootcamp.fypi.fyp_i_yfm.model.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CrumbDto implements Serializable{
  @JsonProperty(value = "")
  private String crumb;


  
}
