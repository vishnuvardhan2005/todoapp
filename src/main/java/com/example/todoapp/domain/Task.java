package com.example.todoapp.domain;

import org.springframework.data.annotation.Id;

public class Task{

    @Id
    private String id;

    private String title;
    private String desc;

    public Task() {}

    public  Task(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return title + " " + desc;
    }

    // Getters
    public String getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}