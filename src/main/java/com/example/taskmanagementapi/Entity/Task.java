package com.example.taskmanagementapi.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taskId;

    String title;

    String description;

    LocalDate dueDate;

    String status;

    @ManyToOne
    @JoinColumn
    User user;

}