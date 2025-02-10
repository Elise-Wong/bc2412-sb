package com.bootcamp.restful.demo_restful.model;

import java.util.Optional;

public class CatDatabase {
  // 1
  public static Cat[] HOME = new Cat[5]; //as final, 大階

  // 2
  // public static boolean put(Cat cat){
  //   for (int i = 0; i < HOME.length; i++){
  //     if (HOME[i] == null){
  //       HOME[i] = cat;
  //       return true;
  //     }
  //   }
  //   return false;
  // }

  // 3
  public static Optional<Cat> find(Long id){
    for (Cat cat : HOME){
      if (cat.getId() == id){
        return Optional.of(cat); //return cat; when Cat find
      }
    }
    return Optional.empty(); //return null; when Cat find
  }

  // 4 - Delete
  public static Boolean delete(Long id){
    for (int i = 0; i < HOME.length; i++){
      if (HOME[i].getId() == id){ //HOME[i] = cat
        HOME[i] = null;
        return true;
      }
    }
    return false;
  }

  // 5 - Update
  public static Boolean update(Long id, Cat cat){
    for (int i = 0; i < HOME.length; i++){
      if (HOME[i].getId() == id){ //HOME[i] = cat
        HOME[i] = cat;
        return true;
      }
    }
    return false;
  }

  // 6 - Path
  // dont cate Cat, we should find the cat object, call setName()
  // other values dof this cat object remain unchanged.
  public static Boolean patchName(Long id, String name){
    for (Cat cat : HOME){
      if (cat.getId() == id){ //HOME[i] = cat
        cat.setName(name);
        return true;
      }
    }
    return false;
  }



  
}
