package com.society;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.society.model"})
@SpringBootApplication
public class SocietyRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyRegisterApplication.class, args);
	}

}
