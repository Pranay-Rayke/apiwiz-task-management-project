package com.example.taskmanagementapi.Service;

import com.example.taskmanagementapi.CustomException.UserNameAlreadyExistsException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.Entity.User;


public interface UserServiceInterface {
    User saveUser(User user) throws UserNameAlreadyExistsException;
    User getUserById(Long userId) throws UserNotFoundException;
   User getUserByUsername(String username) throws UserNotFoundException;
}
