package com.example.taskmanagementapi.Service.Implementation;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.Entity.Task;
import com.example.taskmanagementapi.Entity.User;
import com.example.taskmanagementapi.Repository.TaskRepository;
import com.example.taskmanagementapi.Repository.UserRepository;
import com.example.taskmanagementapi.Service.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Task addTask(Task task, String username) throws UserNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user == null) {
            throw new UserNotFoundException("User Not Found !!!");
        }
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Task> getTasksForUser(Long userId) throws TaskNotFoundException, UserNotFoundException {

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
         return list;
    }

    public Task updateTask(Long taskId, Task updatedTask) throws TaskNotFoundException {
        // Find the task by taskId

        Task task = taskRepository.findById(taskId).get();

        if(task != null)
        {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setDueDate(updatedTask.getDueDate());
            task.setStatus(updatedTask.getStatus());
            task.setUser(updatedTask.getUser());
            return taskRepository.save(task);

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