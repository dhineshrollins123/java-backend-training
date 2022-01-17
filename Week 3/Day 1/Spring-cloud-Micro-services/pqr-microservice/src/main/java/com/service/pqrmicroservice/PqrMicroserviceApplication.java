package com.service.pqrmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PqrMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PqrMicroserviceApplication.class, args);
	}

}
