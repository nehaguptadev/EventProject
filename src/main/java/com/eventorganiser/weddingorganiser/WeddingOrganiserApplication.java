package com.eventorganiser.weddingorganiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*") 
@EntityScan("com.*")
@EnableJpaRepositories(basePackages = {"com.*"})
public class WeddingOrganiserApplication {

	//Main Class
	public static void main(String[] args) {
		SpringApplication.run(WeddingOrganiserApplication.class, args);
	}

}
