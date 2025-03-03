package com.bootcamp.customer.demo_sb_customer;

import static org.mockito.ArgumentMatchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.bootcamp.customer.demo_sb_customer.controller.impl.UserControllerImpl;
import com.bootcamp.customer.demo_sb_customer.dto.UserDTO;
import com.bootcamp.customer.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.bootcamp.customer.demo_sb_customer.model.dto.UserDto;
import com.bootcamp.customer.demo_sb_customer.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserControllerImpl.class)
public class UserControllerNoApiRespTest {
  ///@Test // test for @WebMvcTest is ok or not
  void contextLoad(){

  }

  @MockBean //冇行為的山寨貨
  private UserService userService;

  //@MockBean //10 method, mock 10 method
  @SpyBean //10 method, real 10 method, still mock method
  private UserDTOMapper userDTOMapper; // as Mapper is bean, 所以要mock

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  ///@Test
  void testGetAllUsers() throws Exception{
    // controller: covert List of Dto to List of DTO
    // map 出黎既形狀岩就得了, care abt DTO

    // step 1: Create a object for expected output + 
    // UserDTO userDTO1 = UserDTO.builder()
    //   .email("john@gmail.com")
    //   .name("John Wong")
    //   .id(11L)
    //   .build();
    
    // UserDTO userDTO2 = UserDTO.builder()
    // .email("mary@gmail.com")
    // .name("Mary Chan")
    // .id(12L)
    // .build();

    //List<UserDTO> serviceResult = Arrays.asList(userDTO1, userDTO2);
    UserDto.Address.Geo johnGeo = UserDto.Address.Geo.builder().build();
    UserDto.Address johnAddress = UserDto.Address.builder().geo(johnGeo).build();
    UserDto.Company johnCompany = UserDto.Company.builder().build();
    UserDto john = UserDto.builder().name("john").build();

    UserDto.Address.Geo maryGeo = UserDto.Address.Geo.builder().build();
    UserDto.Address maryAddress = UserDto.Address.builder().geo(maryGeo).build();
    UserDto.Company maryCompany = UserDto.Company.builder().build();
    UserDto mary = UserDto.builder().name("mary").build();

    List<UserDto> userDtos = Arrays.asList(john, mary);

    // step 2: Mock the behavior for mock bean + 
    // step 3: Assume the behavior/result for mock bean
    //Mockito.when(userService.getUsers()).thenReturn(serviceResult);
    Mockito.when(userService.getUser()).thenReturn(userDtos);

    // step 4: Test
    // step 4.1: Perform HTTP
    //String requestBodyJson
    // ResultActions result = mockMvc.perform(get("/users"))
    //   .andExpect((status().isOk()))
    //   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    ResultActions result = mockMvc.perform(get("/jsonplaceholder/users")); //"/jsonplaceholder.typicode.com/users"
    result.andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    // step 4.2: Verify HTTP reponse

  //  this.userService.getUser().stream()
  //     .map(e -> userDTOMapper.map(e))
  //     .collect(Collectors.toList());

    // To check the data:
    String json = result.andReturn().getResponse().getContentAsString();
    List<UserDTO> userDTOs = new ObjectMapper().readValue(json,
        new TypeReference<List<UserDTO>>() {});

    MatcherAssert.assertThat(userDTOs, Matchers.containsInAnyOrder( 
        Matchers.hasProperty("name", Matchers.equalTo("john")), 
        Matchers.hasProperty("name", Matchers.equalTo("mary")) 
    ));


  }


  
}
