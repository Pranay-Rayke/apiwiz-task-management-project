package com.example.taskmanagementapi.Service;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotAdminException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.DTO.RequestDto.TaskRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.TaskResponseDto;
import com.example.taskmanagementapi.Entity.Task;

import java.util.List;

public interface TaskServiceInterface {
    Task addTask(TaskRequestDto taskRequestDto, String username) throws UserNotFoundException, UserNotAdminException;

    List<TaskResponseDto> getTasksForUser(Long userId) throws TaskNotFoundException, UserNotFoundException;
    TaskResponseDto updateTask(Long taskId, TaskRequestDto updatedTask) throws TaskNotFoundException;

    void deleteTask(Long taskId) throws TaskNotFoundException;

}
