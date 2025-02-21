package com.bootcamp.customer.demo_sb_customer.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

// ! DTO: Data transfer object

// this DTO is for deserialization (JSON -> OBJECT)
@Getter
@Builder //for test - UserControllerNoApiRespTest
@ToString
public class UserDto {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;


  // class address
  @Getter
  @Builder //for test - UserControllerNoApiRespTest
  public static class Address{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    // class geo
    @Getter
    @Builder //for test - UserControllerNoApiRespTest
    public static class Geo{
      @JsonProperty(value = "lat") // 人地JSON既名, 現在想改名
      private String latitude;
      @JsonProperty(value = "lng") 
      private String longitude;
    }
  }

  // class company
  @Getter
  @Builder //for test - UserControllerNoApiRespTest
  public static class Company{
    private String name;
    private String catchPhrase;
    private String bs;
  } 
}
