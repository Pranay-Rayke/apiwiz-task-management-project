package com.example.taskmanagementapi.CustomException;

public class UserNameAlreadyExistsException extends Exception {

    public UserNameAlreadyExistsException(String message)
    {
        super(message);
    }
}
