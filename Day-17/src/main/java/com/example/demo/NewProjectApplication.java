package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info =@Info(
				title = "CONTENT-DISCOVERY-APP",
				version = "1.1.2",
				description = "A DATA DISCOVERY APPLICATION",
				contact = @Contact(
						name = "NAVEEN RM",
						email = "NAVEENRAGAV73@GMAIL.COM"
						)
				)
		)
@SpringBootApplication
public class NewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewProjectApplication.class, args);
	}

}
