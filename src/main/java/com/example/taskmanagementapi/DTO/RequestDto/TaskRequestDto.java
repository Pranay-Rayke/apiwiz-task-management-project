package com.example.taskmanagementapi.DTO.RequestDto;

import com.example.taskmanagementapi.Entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskRequestDto {

    String title;

    String description;

    LocalDate dueDate;

    String status;

    UserRequestDto userRequestDto;
}
