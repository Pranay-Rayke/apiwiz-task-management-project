package com.example.taskmanagementapi.Service;

import com.example.taskmanagementapi.CustomException.UserNameAlreadyExistsException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.DTO.RequestDto.UserRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.UserResponseDto;
import com.example.taskmanagementapi.Entity.User;


public interface UserServiceInterface {
    User saveUser(UserRequestDto userRequestDto) throws UserNameAlreadyExistsException;
    UserResponseDto getUserById(Long userId) throws UserNotFoundException;
   UserResponseDto getUserByUsername(String username) throws UserNotFoundException;
}
