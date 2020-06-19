package com.example.todoapp;

import com.example.todoapp.domain.Task;
import com.example.todoapp.repo.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication {
	public static final Logger log = LoggerFactory.getLogger(TodoappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repo) {
		return (args) -> {
			// save tasks
			repo.save(new Task("Task 1", "This is task1"));
			repo.save(new Task("Task 2", "This is a task2"));

			// fetch customers
			log.info("Getting all customers");
			for (Task task :
					repo.findAll()) {
				log.info(task.getTitle(), task.getDesc());
			}
		};
	}
}
