package com.bootcamp.customer.demo_sb_customer;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.units.qual.A;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import com.bootcamp.customer.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.customer.demo_sb_customer.controller.impl.CustomerControllerImpl;
import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.service.CustomerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


// every test file is a testing environment with your target Bean Cycle.
// ! for unit test, we dont need servce, repoitory layer (bean)
//可以no network, no postman

@WebMvcTest(controllers = CustomerControllerImpl.class) // ! Context includes all web related beans ONLY.
////@SpringBootTest //直衝到底
class CustomerControllerTest { //因為每個test是獨立的, 不會有public
  @MockBean 
  private CustomerService customerService;

  // ! @WebMvcTest inject MockMvc Bean (@Mock -> @Autowired) into context
  @Autowired
  private MockMvc mockMvc; // 扮演pretend Postman 

  @Autowired
  private ObjectMapper objectMapper;

// ! Test for GET
  @Test
  void testGetAllCustomers() throws Exception{ 
    // ! Mock behavior for the mock bean
    CustomerEntity customerEntity1 = CustomerEntity.builder()
      .email("test123@gmail.com")
      .name("testname1")
      .id(99L)
      .build();

    CustomerEntity customerEntity2 = CustomerEntity.builder()
      .email("test234@gmail.com")
      .name("testname2")
      .id(999L)
      .build();
    
    List<CustomerEntity> serviceResult = Arrays.asList(customerEntity1, customerEntity2);

    // ! Assume the behavior/result for the mock bean
    Mockito.when(customerService.getCustomers()).thenReturn(serviceResult);

    //method level vs
    //customerController.getCustomers();

    // ! Test
    //ResultActions resul = mockMvc.perform(MockMvcRequestBuilders.get("/customers"));
    ResultActions result = mockMvc.perform(get("/customers"));
    result.andExpect(status().isOk()) //isOk = code200
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    // ! verify result
    // to check the data: 
    // Approach 1
    //result.andExpect(MockMvcResultMatchers.status().isOk()) //isOk = code200
    //result.andExpect(status().isOk()) //isOk = code200
    //  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    result.andExpect(jsonPath("$.code").value("000000"))
      .andExpect(jsonPath("$.message").value("Success."))
      .andExpect(jsonPath("$.data[0].name").value("testname1")) //data[0] = 1st object, assume
      .andExpect(jsonPath("$.data[0].email").value("test123@gmail.com"));

    // Approach 2
    //MvcResult mvcResult = result.andReturn().getResponse().getContentAsString();
    //MatcherAssert.assertThat(); //spring自帶
    String json = result.andReturn().getResponse().getContentAsString();
    //Deserialization: JSON -> object 
    //CustomerEntity[] apiResprray = 
      //new ObjectMapper().readValue(json, CustomerEntity[].class); // json 變 arrays
    //// ApiResp<CustomerEntity> apiResprray = 
    ////   new ObjectMapper().readValue(json, ApiResp.class);
    ApiResp<List<CustomerEntity>> apiResprray = new ObjectMapper()
      .readValue(json, new TypeReference<ApiResp<List<CustomerEntity>>>(){});


    //List<CustomerEntity> customerEntities = Arrays.asList(apiResprray);
      //org.hamcrest.MatcherAssert.assertThat(customerEntities, org.hamcrest.MatcherAssert.hasItem(null));
    ////ApiResp<List<CustomerEntity>>customerEntities = Arrays.asList(apiResprray);
      ////.assertThat(customerEntities, Mathers.hasItem(customerEntity1));

    //MatcherAssert.assertThat(customerEntities, Matchers.hasItem(customerEntity1));
    //MatcherAssert.assertThat(customerEntities, Matchers.hasItem(customerEntity2));
    MatcherAssert.assertThat(apiResprray.getCode(), Matchers.is("000000"));
    MatcherAssert.assertThat(apiResprray.getMessage(), Matchers.is("Success."));

    List<CustomerEntity> customerEntities = apiResprray.getData();

    //MatcherAssert.assertThat(apiResprray, Matchers.containsInAnyOrder(customerEntity1, customerEntity2));

    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(
      Matchers.hasProperty("email", Matchers.equalTo("test123@gmail.com")),
      Matchers.hasProperty("email", Matchers.equalTo("test234@gmail.com"))
    ));
  }

// ! Test for POST/create
    @Test
    void testCreateCustoemr() throws Exception{
      // step 1: Create a object for expected output
      // ! Mock Behavior (pass Mary, return John)
      CustomerEntity customerEntity3 = CustomerEntity.builder()
      .email("test345@gmail.com")
      .name("John")
      .id(9999L)
      .build(); 

      CustomerEntity customerEntityRequest = CustomerEntity.builder()
      .email("mary@gmail.com")
      .name("Mary Chan")
      .id(11L)
      .build(); 

      // step 1: Mock the behavior for mock bean +
      // step 2: Assume the behavior/result for mock bean
      Mockito.when(customerService.createCustomer(customerEntityRequest)).thenReturn(customerEntity3);

      // step 3: Test
      // step 3.1: Perform HTTP
      // ! Prepare Request Body (Mary)
      // ! Serialization
      String requestBodyJson = new ObjectMapper().writeValueAsString(customerEntityRequest);
      System.out.println("requestBodyJson=" + requestBodyJson);

      ResultActions result = mockMvc.perform(post("/customers")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(requestBodyJson))
      // step 3.2: Verify HTTP reponse
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

      // step 4: Verify result
      // ! Get response, extract response data to validate
      String json = result.andReturn().getResponse().getContentAsString();
      System.out.println("json=" + json);

      // ! Deserialization
      // ! Key for this test
      ApiResp<CustomerEntity> apiResp = new ObjectMapper()
        .readValue(json, new TypeReference<ApiResp<CustomerEntity>>() {});

      MatcherAssert.assertThat(apiResp.getCode(), Matchers.is("000000"));
      MatcherAssert.assertThat(apiResp.getMessage(), Matchers.is("Success."));

      CustomerEntity responseData = apiResp.getData();

      MatcherAssert.assertThat(responseData.getName(), Matchers.is("John"));

      //
      verify(customerService, times(1)).createCustomer(customerEntityRequest);




    }

  
}
