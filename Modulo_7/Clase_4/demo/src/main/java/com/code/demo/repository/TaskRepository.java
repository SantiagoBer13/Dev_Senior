package com.code.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.demo.models.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject_Id(Long projectId);
}
