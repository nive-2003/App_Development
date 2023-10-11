package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Controller.RegisterRequest;
import com.example.demo.Service.AuthenticationService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import static com.example.demo.Entity.Role.ADMIN;
import static com.example.demo.Entity.Role.MANAGER;
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
	
//	@Bean
//	public CommandLineRunner commandLineRunner(AuthenticationService service) {
//		return args -> {
//			var admin = RegisterRequest.builder()
//					.username("Admin")
//					.email("admin@gmail.com")
//					.password("admin")
//					.role(ADMIN)
//					.build();
//			System.out.println("Admin token: " + service.register(admin).getToken());
//
//			var manager = RegisterRequest.builder()
//					.username("Manager")
//					.email("manager@gmail.com")
//					.password("manager")
//					.role(MANAGER)
//					.build();
//			System.out.println("Manager token: " + service.register(manager).getToken());
//
//		};
//	}

}
