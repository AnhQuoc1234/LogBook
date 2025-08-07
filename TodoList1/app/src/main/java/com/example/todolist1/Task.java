package com.example.todolist1;

import java.io.Serializable;

public class Task implements Serializable {
    private String name;
    private String deadline;
    private String duration;
    private String description;

    public Task(String name, String deadline, String duration, String description) {
        this.name = name;
        this.deadline = deadline;
        this.duration = duration;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDeadline() { return deadline; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}