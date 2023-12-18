package com.example.taskmanagementapi.Repository;

import com.example.taskmanagementapi.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
//
    Task findByTaskId(Long taskId);

}