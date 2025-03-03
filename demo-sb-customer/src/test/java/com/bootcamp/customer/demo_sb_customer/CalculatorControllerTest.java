package com.bootcamp.customer.demo_sb_customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bootcamp.customer.demo_sb_customer.controller.impl.CalculatorController;
import com.bootcamp.customer.demo_sb_customer.service.CalculatorService;

@WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest {
  @MockBean
  private CalculatorService calculatorService;
  
  @Autowired
  private MockMvc mockMvc;

  // ! this unit test case is to test 2 things:
  // 1. jsonPath("$.value") -> the response must be an object
  // 2. the logic is to test if the result of sum() minus the results of subtract()
  ///@Test
  void calculateTest() throws Exception{
    Mockito.when(calculatorService.sum(1, 2)).thenReturn(100);
    Mockito.when(calculatorService.subtract(1, 2)).thenReturn(200);

    //test
    //ResultActions result = 
    // mockMvc.perform(get("/calculate/{x}/{y}").param("x", "1").param("y", "2"))
    //   .andExpect(jsonPath("$.value").value(-100));
    mockMvc.perform(get("/calculate/{x}/{y}", 1, 2))
       .andExpect(jsonPath("$.value").value(-100));
  }

  
}
