package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.security.config.StudentConfig;
import com.example.security.controller.StudentController;
import com.example.security.controller.TestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootReactorR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorR2dbcApplication.class, args);
	}

}
