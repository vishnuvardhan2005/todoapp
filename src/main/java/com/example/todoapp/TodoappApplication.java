package com.example.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication {
	public static final Logger log = LoggerFactory.getLogger(TodoappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}
}
