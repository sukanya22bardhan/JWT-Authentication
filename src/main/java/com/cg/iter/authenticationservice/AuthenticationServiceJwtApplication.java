package com.cg.iter.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Name-AuthenticationServiceJwtApplication Description- It is to start the
 * Spring boot application.
 */

@SpringBootApplication
@EnableSwagger2
public class AuthenticationServiceJwtApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceJwtApplication.class, args);
	}
}
