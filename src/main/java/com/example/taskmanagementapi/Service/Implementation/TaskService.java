package com.example.taskmanagementapi.Service.Implementation;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotAdminException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.DTO.RequestDto.TaskRequestDto;
import com.example.taskmanagementapi.DTO.RequestDto.UserRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.TaskResponseDto;
import com.example.taskmanagementapi.Entity.Task;
import com.example.taskmanagementapi.Entity.User;
import com.example.taskmanagementapi.Repository.TaskRepository;
import com.example.taskmanagementapi.Repository.UserRepository;
import com.example.taskmanagementapi.Service.TaskServiceInterface;
import com.example.taskmanagementapi.Transformer.TaskTransformer;
import com.example.taskmanagementapi.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Task addTask(TaskRequestDto taskRequestDto, String username) throws UserNotFoundException, UserNotAdminException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UserNotFoundException("User Not Found !!!");
        }
        if(user.isAdmin() == false)
        {
            throw new UserNotAdminException("You are not a Admin");
        }
        Task task = TaskTransformer.TaskRequestDtoToTask(taskRequestDto);
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<TaskResponseDto> getTasksForUser(Long userId) throws TaskNotFoundException, UserNotFoundException {

            User user = userRepository.findById(userId).get();
            if(user==null)
            {
                throw new UserNotFoundException("User Not Found !!!");
            }
            List<Task> list = taskRepository.findByUserId(userId);

            if(list == null)
            {
                throw new TaskNotFoundException("Task Not Found !!!");
            }
             List<TaskResponseDto> result = new ArrayList<>();

            for(Task task : list)
            {
            result.add(TaskTransformer.TaskToTaskResponseDto(task));
            }
         return result;
    }

    public TaskResponseDto updateTask(Long taskId, TaskRequestDto updatedTask) throws TaskNotFoundException {
        // Find the task by taskId

        Task task = taskRepository.findById(taskId).get();

        if(task != null)
        {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDueDate(updatedTask.getDueDate());
            task.setStatus(updatedTask.getStatus());
            Task task1 = taskRepository.save(task);
            TaskResponseDto taskResponseDto = TaskTransformer.TaskToTaskResponseDto(task1);
            return taskResponseDto;
        }
         else {
            throw new TaskNotFoundException("Task Not Found !!!");
        }
    }


    public void deleteTask(Long taskId) throws TaskNotFoundException {

        Task task = taskRepository.findByTaskId(taskId);
        if(task == null)
        {
            throw new TaskNotFoundException("Task Not Found");
        }
        taskRepository.deleteById(taskId);
    }
}