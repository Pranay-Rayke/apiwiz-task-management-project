package com.example.taskmanagementapi.Service;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.Entity.Task;

import java.util.List;

public interface TaskServiceInterface {
//    Task addTask(Task task, String username) throws UserNotFoundException;

//    List<Task> getTasksForUser(Long userId) throws TaskNotFoundException, UserNotFoundException;
    Task updateTask(Long taskId, Task updatedTask) throws TaskNotFoundException;

//    void deleteTask(Long taskId) throws TaskNotFoundException;

}
