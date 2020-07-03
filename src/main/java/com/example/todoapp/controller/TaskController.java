package com.example.todoapp.controller;

import com.example.todoapp.domain.Task;
import com.example.todoapp.error.TaskNotFoundException;
import com.example.todoapp.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Controller for Task
@Controller
@RequestMapping("/tasks")
public class TaskController {
    private Logger Log = LoggerFactory.getLogger(TaskController.class);

    // Service
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL
    @GetMapping("")
    public ResponseEntity<List<Task>> all() {
        // Get all tasks
        List<Task> tasks = taskService.getAll();

        // Return in Response
        return ResponseEntity.ok(tasks);
    }

    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<Task> one(@PathVariable String id) {
        // Get the task
        Task task = taskService.getById(id);

        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            // task could not be found. Return error
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE POST
    @PostMapping("")
    ResponseEntity<Task> create(@RequestBody Task task) {
        Task result = taskService.save(task);
        if (result!=null){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    ResponseEntity<Task> update(@RequestBody Task task, @PathVariable String id) {
        Task dbTask = taskService.getById(id);
        Task result;
        if (dbTask!=null) {
            // update it
            dbTask.setTitle(task.getTitle());
            dbTask.setDesc(task.getDesc());
            result =  taskService.save(dbTask);
        } else {
            result = taskService.save(task);
        }

        if (result!=null){
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    void remove(@PathVariable String id) {
        taskService.deleteById(id);
    }
}
