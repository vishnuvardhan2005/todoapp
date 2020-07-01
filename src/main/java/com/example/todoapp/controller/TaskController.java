package com.example.todoapp.controller;

import com.example.todoapp.domain.Task;
import com.example.todoapp.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Controller for Task
@Controller
public class TaskController {
    private Logger Log = LoggerFactory.getLogger(TaskController.class);

    // Service
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET ALL
    @GetMapping("/tasks")
    public String all(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "task/list";
    }

    // GET ONE
    @GetMapping("tasks/{id}")
    public String one(@PathVariable String id, Model model) {
        model.addAttribute("task", taskService.getById(id));
        return "task/show";
    }

    /*
    // CREATE GET
    @GetMapping("task")
    public String create() {
        return "task/taskform";
    }

    // CREATE POST
    @PostMapping("/task")
    String create(@RequestBody Task task, Model model) {
        Log.debug(task.getTitle());
        Log.debug(task.getDesc());
        repo.save((task));
        model.addAttribute("task", task);
        return "viewtask";
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

     */
}
