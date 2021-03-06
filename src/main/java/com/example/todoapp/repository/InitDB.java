package com.example.todoapp.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {
    private static final Logger Log = LoggerFactory.getLogger(InitDB.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository repo) {
        return args -> {
            Log.info("Creating DB...");
            //repo.save(new Task("Clean house", "Clean the full house"));
            //repo.save(new Task("Get grocery", "Get montly grocery"));
            Log.info("Finished db creation");
        };
    }
}
