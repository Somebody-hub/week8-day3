package com.example.week8_day3.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }
}
