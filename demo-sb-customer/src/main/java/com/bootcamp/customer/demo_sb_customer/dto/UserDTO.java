package com.bootcamp.customer.demo_sb_customer.dto;

import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Features of DTO
// ! Different number of fields for the API
// ! Difference field names

// this DTO is for serialization (OBJECT -> JSON)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor //
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;


  // class address
  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor //
  public static class Address{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    // class geo
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor //
    public static class Geo{
      @JsonProperty(value = "x") // 人地JSON既名, 現在想改名
      private String latitude;
      @JsonProperty(value = "y") 
      private String longitude;
    }
  }






 public static void main(String[] args) {
  // UserDto userDto = new UserDto();
  // com.bootcamp.customer.demo_sb_customer.model.dto.UserDto userDto2 =
  //   new com.bootcamp.customer.demo_sb_customer.model.dto.UserDto();

  //cant import

  //UserDTO userDTO = new UserDTO();


 } 
}
