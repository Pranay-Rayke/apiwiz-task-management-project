package com.example.taskmanagementapi.CustomException;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message)
    {
        super(message);
    }
}
