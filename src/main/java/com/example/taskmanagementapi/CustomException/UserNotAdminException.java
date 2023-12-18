package com.example.taskmanagementapi.CustomException;

public class UserNotAdminException extends Exception{

    public UserNotAdminException(String message)
    {
        super(message);
    }
}
