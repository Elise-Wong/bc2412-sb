package com.bootcamp.two.hw_sb_two.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;
  private List<PostDTO> posts;

  // class address
  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  public static class AddressDTO{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    // class geo
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class GeoDTO{
      @JsonProperty(value = "lat")
      private String latitude;
      @JsonProperty(value = "lng") 
      private String longitude;
    }
  }

  // class company
  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  public static class CompanyDTO{
    private String name;
    private String catchPhrase;
    private String bs;
  } 
  
 //@OneToMany(mappedBy = )

}
