package com.app.CareerGuidance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.app.CareerGuidance.Repository", "com.app.CareerGuidance.Service"})
public class CareerGuidanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareerGuidanceApplication.class, args);
	}

}
