package com.bootcamp.customer.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//”mvn install”: includes “mvn test”
//”mvn compile”: ensure main code syntax alright.
//“mvn test-compile”: ensures test code syntax alright
//“mvn test”: execute test  @SpringBootTest  test once for the target testing environment.


@SpringBootTest // simulate the actual Spring Bean Cycle. 把成個class變成environment
class DemoSbCustomerApplicationTests {

	// ! test all dependency between componentse (@controller, @service, @autowired etc.)
	///@Test
	void contextLoads() {
	}

}
