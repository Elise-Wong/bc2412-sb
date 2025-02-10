package com.bootcamp.restful.demo_restful.service.impl;

import org.springframework.stereotype.Service;

import com.bootcamp.restful.demo_restful.model.Cat;
import com.bootcamp.restful.demo_restful.model.CatDatabase;
import com.bootcamp.restful.demo_restful.service.CatService;

@Service // = Bean // Bean 放係Spring
public class CatServiceImpl implements CatService{
    // stateless: 這object 是冇狀態 (no attribute), 有資格變做Beam
    // stateless object can be a bean.

    // Person.class -> name -> setName() -> getName()
    // vs
    // Person.class -> weight/height -> bmi()
    @Override
    public boolean put(Cat cat){
    for (int i = 0; i < CatDatabase.HOME.length; i++){
      if (CatDatabase.HOME[i] == null){
        CatDatabase.HOME[i] = cat;
        return true;
      }
    }
    return false;
  }

  //有狀態: 有機會影響行為
  // private int x;
  // public boolean put(Cat cat){
  //   if (xxx)
  // }
  
}
