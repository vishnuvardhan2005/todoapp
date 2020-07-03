package com.example.todoapp.service;

import com.example.todoapp.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAll();

    Task getById(String id);

    Task save(Task task);

    void deleteById(String id);

    Optional<Task> getFirst();
}
