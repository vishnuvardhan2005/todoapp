package com.example.todoapp.repo;

import com.example.todoapp.domain.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository_MongoDB extends MongoRepository<Task, Long> {
}