package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@SpringBootApplication
public class ZconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZconfigApplication.class, args);
	}

//	@Value("${config.name}")
//	String name = "World";
//
//	@RequestMapping("/")
//	public String home() {
//		return "Hello " + name;
//	}
}
