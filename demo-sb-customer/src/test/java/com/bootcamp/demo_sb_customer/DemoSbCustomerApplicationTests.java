package com.bootcamp.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


// mvn clean install includes "mvn test"
// mvn compile -> ensures main code syntax alright
// mvn test-compile -> ensure test code syntax alright
// mvn test -> execute test -> @SpringBootTest -> test whole enviroment for the target testing env.
@SpringBootTest // simulte the actual Spring cycle (Bean Cycle). Start from Component scan 
class DemoSbCustomerApplicationTests {

	// 宜家已經係 test case
	// test all dependency between components (Controller, Service, Value, ...)
	@Test 
	void contextLoads() {
	}

}
