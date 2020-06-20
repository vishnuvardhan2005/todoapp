package com.example.todoapp.api;

import com.example.todoapp.domain.Task;
import com.example.todoapp.error.TaskNotFoundException;
import com.example.todoapp.repo.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository repo;

    TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    // GET ALL
    @GetMapping("/tasks")
    List<Task> all() {
        return (List<Task>) repo.findAll();
    }

    // GET ONE
    @GetMapping("tasks/{id}")
    Task one(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() ->new TaskNotFoundException());
    }

    // CREATE
    @PostMapping("/tasks")
    Task create(@RequestBody Task task) {
        return repo.save((task));
    }

    // UPDATE
    @PutMapping("tasks/{id}")
    Task update(@RequestBody Task task, @PathVariable Long id) {
        Task task_in_db = repo.findById(id).orElse(null);
        if (task_in_db != null){
            task_in_db.setDesc(task.getDesc());
            task_in_db.setTitle(task.getTitle());
            return repo.save(task_in_db);
        } else {
            return repo.save(task);
        }
    }

    // DELETE
    @DeleteMapping("tasks/{id}")
    void remove(@PathVariable Long id) {
        repo.deleteById(id);
    }

}
