package com.techienotes.movieprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProviderApplication.class, args);
	}

}
