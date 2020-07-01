package com.example.todoapp.service;

import com.example.todoapp.domain.Task;
import com.example.todoapp.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private Logger Log = LoggerFactory.getLogger(TaskServiceImpl.class);
    TaskRepository taskRepository;

    @Autowired
    void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(String id){
        Task task = getAll().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        return task;
    }
}
