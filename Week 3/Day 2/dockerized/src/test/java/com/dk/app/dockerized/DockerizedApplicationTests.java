package com.dk.app.dockerized;

import com.dk.app.dockerized.controller.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerizedApplicationTests {

	@Autowired
	private AppController controller;

	@DisplayName("Context : Spring Application Context Loaded")
	@Test
	void contextLoads() {
		Assertions.assertNotNull(controller);
	}

}
