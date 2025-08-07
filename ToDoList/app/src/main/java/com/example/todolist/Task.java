package com.example.todolist;

import java.io.Serializable;

public class Task implements Serializable {
    private int id; // only used for database
    private String name;
    private String deadline;
    private String duration;
    private String description;

    // Constructor without ID (for creating new task)
    public Task(String name, String deadline, String duration, String description) {
        this.name = name;
        this.deadline = deadline;
        this.duration = duration;
        this.description = description;
    }

    // Constructor with ID (for reading from database)
    public Task(int id, String name, String deadline, String duration, String description) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.duration = duration;
        this.description = description;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDeadline() { return deadline; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}
