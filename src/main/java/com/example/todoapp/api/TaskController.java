package com.example.todoapp.api;

import com.example.todoapp.domain.Task;
import com.example.todoapp.repo.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository repo;

    TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    // Get all
    @GetMapping("/tasks")
    List<Task> all() {
        return (List<Task>) repo.findAll();
    }

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task task) {
        return repo.save(task);
    }
}
