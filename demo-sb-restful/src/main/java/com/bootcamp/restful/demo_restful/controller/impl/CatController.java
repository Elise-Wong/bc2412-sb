package com.bootcamp.restful.demo_restful.controller.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootcamp.restful.demo_restful.controller.CatOperation;
import com.bootcamp.restful.demo_restful.model.Cat;
import com.bootcamp.restful.demo_restful.model.CatDatabase;
import com.bootcamp.restful.demo_restful.service.CatService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


// ! RESTful API -> GET/POST/DELETE/PUT/PATCH
// control single resource by GET/POST/DELETE/PUT/PATCH


// controller -> the ways to control Cat resource
// insert, update, delete, select
@Controller  // call service
@ResponseBody
public class CatController implements CatOperation{
  // Controller -> Service -> CatDatabase

  // Dependency Injection (Spring Core Concept)
  // ! Autowired: try (it means may fail) to find an object which fits into catService (type), before Server start complete
  // ! if fail, Server start fail
  // Field Injection
  @Autowired  // default true //一定要搵到
  private CatService catService;

  // Allagain constructor 
  // Constructor Injection = Autowired
  //少用
  // public CatController(CatService catService){
  //   this.catService = catService;
  // }

  // insert only
  @Override
  public Cat createCat(@RequestBody Cat cat){
    //if (CatDatabase.put(cat))
    if (this.catService.put(cat)) //Null pointer exception?  
    //if (new Cat.put(cat)): memory 波動好大 vs if (this.catService.put(cat)): memory 波動相對小 vs if (new catService().put(cat)): memory 波動大, 畫蛇添足
      return cat;
    return null; // 因為CatDatabase set左做5隻, 如果第6隻就會變冇野(null)
  }

  //Get All Cats
  // @PostMapping(value = "/cats")
  // public Cat[] getAllCats() {
  //     return CatDatabase.HOME;
  // }
  //API cosumer
  // Arrays.asList() ..多用 vs List.of()..多用  vs new ArrayList<>() ..少用
  
  public List<Cat> getCats() {
      return List.of(CatDatabase.HOME); //
  }

  //Get Cat by id
  // http://localhost:8082/cat?Id=1
  // Deserialization
 
  public Cat getCat(Long id) { //(@RequestParam(value = "catId") Long id) // http://localhost:8082/cat?catId=1
    new Cat(id, null, null);
    return CatDatabase.find(id).orElse(null);
  }

  //Get Cat by name

  //4 - Deletmapping
  // http://localhost:8082/cat?id=1
 
  public Boolean deleteCat(Long id){
    return CatDatabase.delete(id);
  }

  //5 - HashMap.put() -> if exists, override, otherwise, create new

  public Boolean updateCat(Long id, Cat cat){ //replace
    return CatDatabase.update(id, cat);
  }

  // 6
   //Patch:only can correct a little
  public Boolean patchCatName(Long id, String name){
    return CatDatabase.patchName(id, name);
  }


  
  
}
