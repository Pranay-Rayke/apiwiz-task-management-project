package com.example.taskmanagementapi.Controller;

import com.example.taskmanagementapi.CustomException.TaskNotFoundException;
import com.example.taskmanagementapi.CustomException.UserNotFoundException;
import com.example.taskmanagementapi.DTO.RequestDto.TaskRequestDto;
import com.example.taskmanagementapi.DTO.RequestDto.UserRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.TaskResponseDto;
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
    public ResponseEntity addTask(@RequestBody TaskRequestDto taskRequestDto, @RequestParam String username) throws UserNotFoundException {
        try{
            taskService.addTask(taskRequestDto, username);
            return new ResponseEntity("Task Added Successfully", HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getTaskForUser/{userId}")
    public ResponseEntity getTasksForUser(@PathVariable Long userId) throws UserNotFoundException, TaskNotFoundException {
        try {
            List<TaskResponseDto> tasks = taskService.getTasksForUser(userId);
            return new ResponseEntity(tasks, HttpStatus.OK);
        }
        catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (TaskNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto updatedTask) throws TaskNotFoundException {
        try {
            TaskResponseDto taskResponseDto = taskService.updateTask(taskId, updatedTask);
            return new ResponseEntity(taskResponseDto, HttpStatus.OK);
        }
        catch (TaskNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
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
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}