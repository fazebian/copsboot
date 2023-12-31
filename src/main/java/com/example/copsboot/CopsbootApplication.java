package com.example.copsboot;

import com.example.copsboot.jpa.InMemoryUniqueIdGenerator;
import com.example.copsboot.jpa.UniqueIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CopsbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopsbootApplication.class, args);
	}
	@Bean
	public UniqueIdGenerator<UUID> uniqueIdGenerator() {
		return new InMemoryUniqueIdGenerator();
	}

}
