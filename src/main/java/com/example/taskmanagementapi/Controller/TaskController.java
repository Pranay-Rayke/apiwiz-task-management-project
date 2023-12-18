package com.example.taskmanagementapi.Controller;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.Entity.Task;
import com.example.taskmanagementapi.Entity.User;
import com.example.taskmanagementapi.Service.Implementation.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity addTask(@RequestBody Task task, User user) throws UserNotFoundException {
        try{
            String username = user.getUsername();
            taskService.addTask(task, username);
            return new ResponseEntity("Task Added Successfully", HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }

    @GetMapping("/getTaskForUser/{userId}")
    public ResponseEntity getTasksForUser(@PathVariable Long userId) throws UserNotFoundException, TaskNotFoundException {
        try {
            List<Task> tasks = taskService.getTasksForUser(userId);
            return new ResponseEntity(tasks, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
        catch (TaskNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) throws TaskNotFoundException {
        try {
            Task task = taskService.updateTask(taskId, updatedTask);
            return new ResponseEntity(task, HttpStatus.OK);
        }
        catch (TaskNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Long taskId) throws TaskNotFoundException {
        try {
            taskService.deleteTask(taskId);
            return new ResponseEntity("Task Deleted Successfully",HttpStatus.OK);
        }
        catch (TaskNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
    }
}