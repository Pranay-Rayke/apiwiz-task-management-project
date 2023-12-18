package com.example.taskmanagementapi.CustomException;

public class TaskNotFoundException extends Exception{

    public TaskNotFoundException(String message)
    {
        super(message);
    }
}
