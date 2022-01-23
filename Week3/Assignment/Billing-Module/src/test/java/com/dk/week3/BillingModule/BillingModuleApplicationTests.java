package com.dk.week3.BillingModule;

import com.dk.week3.BillingModule.controller.BillController1;
import com.dk.week3.BillingModule.controller.BillController2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BillingModuleApplicationTests {


	@Autowired
	private BillController1 controller1;

	@Autowired
	private BillController2 controller2;

	@DisplayName("Context 1 : Spring Application Context Loaded")
	@Test
	void contextLoads1() {
		Assertions.assertNotNull(controller1);
	}
	@DisplayName("Context 2: Spring Application Context Loaded")
	@Test
	void contextLoads2() {
		Assertions.assertNotNull(controller2);
	}

}
