package com.techienotes.movieconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieConsumerApplication.class, args);
	}

}
