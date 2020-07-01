package com.example.todoapp.service;

import com.example.todoapp.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task getById(String id);
}
