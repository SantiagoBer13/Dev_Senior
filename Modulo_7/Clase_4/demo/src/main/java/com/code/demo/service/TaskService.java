package com.code.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.code.demo.models.dto.DTOProjectRequest;
import com.code.demo.models.dto.DTOProjectResponse;
import com.code.demo.models.dto.DTOTaskRequest;
import com.code.demo.models.dto.DTOTaskResponse;

@Service
public interface TaskService {

    List<DTOTaskResponse> getAllTasks();

    List<DTOTaskResponse> getAllTasksByProject(Long projectId);

    @PreAuthorize("hasAnyRole('ADMIN')")
    DTOTaskResponse createTask(DTOTaskRequest dtoTaskRequest);

    @PreAuthorize("hasAnyRole('ADMIN')")
    void deleteTaskById(Long id);

}   
