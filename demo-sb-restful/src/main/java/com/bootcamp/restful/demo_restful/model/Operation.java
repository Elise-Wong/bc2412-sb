package com.bootcamp.restful.demo_restful.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    SUM, SUBTRACT, MULTIPLY, DIVIDE,;

    //return the above
    // public String lowercase(){
    //   return this.name().toLowerCase(); 
    // }

    // @JsonCreator
    // public static Operation frojmSting(Sting value){
    //   for (Operation op : Operation.valueOf()){
    //     if (op.name().equalsIgnoreCase(value)){

    //     }
    //   }
    // }
}
