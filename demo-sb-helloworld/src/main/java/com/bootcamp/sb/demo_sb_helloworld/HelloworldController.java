package com.bootcamp.sb.demo_sb_helloworld;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.sb.demo_sb_helloworld.ShoppingMall.Cinema;
import com.bootcamp.sb.demo_sb_helloworld.ShoppingMall.Cinema.Film;

import org.springframework.web.bind.annotation.RequestParam;

// Java object -> JSON (Serialization)
// JSON -> Java Object (Deserialization)
// lanage independancy

// Attribute has no ordering in JSON.

@Controller // for @GetMapping ...pin text only
@ResponseBody // return to JSON, for html
public class HelloworldController {

  // an API for Getting Resource
  @GetMapping(value = "/greeting") // 用名詞, unique
  public String hello() {
    return "Hello World !";
  }

  // create another API to return an Integer
  @GetMapping(value = "/integer")
  public Integer getInteger() {
    return 111;
  }

  // create another API to return Integer array
  @GetMapping(value = "/integers")
  public Integer[] getintegers() {
    return new Integer[] { 1, 2, 3 };
  }

  // create another API to return List of String
  @GetMapping(value = "/listOfString")
  public List<String> getStrings() {
    return Arrays.asList("vin", "lucas");
  }

  // create another API to return a Cat
  @GetMapping(value = "/cat")
  public Cat getCat() {
    return new Cat("meow");
  }

    // create another API to return a List of Cat
    @GetMapping(value = "/cats")
    public List<Cat> getCats() {
      return Arrays.asList(new Cat("neko"), new Cat("meow"), new Cat("chat"));
    }

    // create another API to return a List of LocalDate
    @GetMapping(value = "/dates")
    public List<LocalDate> getDates() {
       return Arrays.asList(LocalDate.of(2024, 02, 14), LocalDate.of(2025, 02, 14));
     }

    @GetMapping(value = "/shoppingmall")
    public ShoppingMall getShopmall() {
      Film film1 = Film.builder()
          .name("film A")
          .releaseDate(LocalDate.of(2022, 01, 01))
          .build();

      Film film2 = Film.builder()
          .name("film B")
          .releaseDate(LocalDate.of(2022, 01, 02))
          .build();

      ShoppingMall.Cinema cinema = Cinema.builder()
          .releasedFilms(new Film[] { film1, film2 })
          .name("ABC")
          .build();
      return ShoppingMall.builder()
          .name("K11")
          .area(19000)
          .cinema(cinema)
          .shopCategory(new String[] { "Sport", "Food", "Clothing" })
          .build();

    }
    // class
  public static class Cat {
    private String name;

    public Cat(String name) {
      this.name = name;
    }

    public String getCat() {
      return this.name;
    }

}  

  }

