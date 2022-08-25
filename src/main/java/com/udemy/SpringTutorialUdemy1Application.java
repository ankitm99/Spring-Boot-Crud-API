package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.udemy.controller","com.udemy.service"})
@EntityScan("com.udemy.entity")
@EnableJpaRepositories("com.udemy.studentrepository")
public class SpringTutorialUdemy1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialUdemy1Application.class, args);
	}

}
