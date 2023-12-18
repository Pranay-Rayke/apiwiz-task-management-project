package com.example.taskmanagementapi.Transformer;

import com.example.taskmanagementapi.DTO.RequestDto.TaskRequestDto;
import com.example.taskmanagementapi.DTO.ResponseDto.TaskResponseDto;
import com.example.taskmanagementapi.Entity.Task;

public class TaskTransformer {

    public static Task TaskRequestDtoToTask(TaskRequestDto taskRequestDto){

        return Task.builder()
                .title(taskRequestDto.getTitle())
                .status(taskRequestDto.getStatus())
                .dueDate(taskRequestDto.getDueDate())
                .description(taskRequestDto.getDescription())
                .build();
    }

    public static TaskResponseDto TaskToTaskResponseDto(Task task)
    {
        return TaskResponseDto.builder()
                .title(task.getTitle())
                .status(task.getStatus())
                .dueDate(task.getDueDate())
                .description(task.getDescription())
                .build();
    }
}
