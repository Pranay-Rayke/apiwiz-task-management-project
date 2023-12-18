package com.example.taskmanagementapi.DTO.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskResponseDto {

    String title;

    String description;

    LocalDate dueDate;

    String status;

}
