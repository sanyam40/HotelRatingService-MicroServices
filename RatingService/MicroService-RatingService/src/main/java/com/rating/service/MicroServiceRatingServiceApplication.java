package com.rating.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRatingServiceApplication.class, args);
	}

}
