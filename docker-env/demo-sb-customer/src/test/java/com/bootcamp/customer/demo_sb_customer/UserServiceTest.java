package com.bootcamp.customer.demo_sb_customer;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bootcamp.customer.demo_sb_customer.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
  @MockBean
  private UserRepository userRepository;


  
}
