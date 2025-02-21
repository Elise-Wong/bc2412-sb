package com.bootcamp.customer.demo_sb_customer;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bootcamp.customer.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.customer.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.customer.demo_sb_customer.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {
  @Autowired
  private CustomerService customerService;

  @MockBean
  private CustomerRepository customerRepository;

  // @InjectMocks
  // private 


  @Test
  void testGetAllCustomers(){
    //Step 1: create object
    // ! Mock behavior for the mock bean
    CustomerEntity customerEntity1 = CustomerEntity.builder()
      .email("John@gmail.com")
      .name("john")
      .id(99L)
      .build();

    CustomerEntity customerEntity2 = CustomerEntity.builder()
      .email("mary@gmail.com")
      .name("mary")
      .id(999L)
      .build();

    List<CustomerEntity> dbResult = Arrays.asList(customerEntity1, customerEntity2);

    // ! Assume the behavior/result for the mock bean
    Mockito.when(customerRepository.findAll()).thenReturn(dbResult);

    // test
    List<CustomerEntity> customerEntities = customerService.getCustomers();


//contrains in here 是要包哂所有可能性
    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(
      Matchers.hasProperty("name", Matchers.equalTo("john")),
      Matchers.hasProperty("name", Matchers.equalTo("mary"))
    ));
    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(
      Matchers.hasProperty("email", Matchers.equalTo("John@gmail.com")),
      Matchers.hasProperty("email", Matchers.equalTo("mary@gmail.com"))
    ));
      MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder(
      Matchers.hasProperty("id", Matchers.equalTo("99L")),
      Matchers.hasProperty("id", Matchers.equalTo("999L"))
    ));
    



  }
}