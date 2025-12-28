package com.code.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.demo.models.dto.DTOProjectRequest;
import com.code.demo.models.dto.DTOProjectResponse;
import com.code.demo.models.dto.DTOTaskRequest;
import com.code.demo.models.dto.DTOTaskResponse;
import com.code.demo.service.ImplProjectService;
import com.code.demo.service.ImplTaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Autowired
    private ImplProjectService implProjectService;

    @Autowired
    private ImplTaskService implTaskService;

    @GetMapping("")
    public List<DTOProjectResponse> getAllProjects() {
        return implProjectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<DTOProjectResponse> getProjectById(@PathVariable Long id) {
        return implProjectService.getProjectById(id);
    }
    
    @PostMapping("")
    public DTOProjectResponse createProject(@Valid @RequestBody DTOProjectRequest dtoProjectRequest) {
        return implProjectService.createProject(dtoProjectRequest);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProjectById(@RequestParam Long id) {
        implProjectService.deleteProjectById(id);
    }

    @PostMapping("/tasks")
    public ResponseEntity<DTOTaskResponse> createTask(@Valid @RequestBody DTOTaskRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(implTaskService.createTask(req));
    }

    @GetMapping("/{id}/tasks")
    public List<DTOTaskResponse> getTasksProjectById(@PathVariable Long id) {
        return implTaskService.getAllTasksByProject(id);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        implTaskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}