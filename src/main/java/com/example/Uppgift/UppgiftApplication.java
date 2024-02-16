package com.example.Uppgift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class UppgiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(UppgiftApplication.class, args);
	}

}
