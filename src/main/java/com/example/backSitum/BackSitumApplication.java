package com.example.backSitum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.backSitum.model")
@EnableJpaRepositories(basePackages = "com.example.backSitum.repository")
@ComponentScan(basePackages = "com.example.backSitum")
public class BackSitumApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackSitumApplication.class, args);
	}

}
