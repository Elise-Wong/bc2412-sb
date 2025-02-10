package com.bootcamp.sb.demo_sb_helloworld;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter // for Serialization (object -> JSON) only
@Builder
public class ShoppingMall {
  private String name;
  private int area;
  private Cinema cinema;
  private String[] shopCategory;

  @Getter
  @Builder
  public static class Cinema {
    private String name;
    private LocalDate openedDate;
    private Film[] releasedFilms;

    @Getter
    @Builder
    public static class Film {
      private String name;
      private LocalDate releaseDate;
    }

  }

}
