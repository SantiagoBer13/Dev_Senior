package com.code.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.demo.mapper.ProjectMapper;
import com.code.demo.mapper.TaskMapper;
import com.code.demo.models.dto.DTOTaskRequest;
import com.code.demo.models.dto.DTOTaskResponse;
import com.code.demo.models.entity.Project;
import com.code.demo.models.entity.Task;
import com.code.demo.repository.ProjectRepository;
import com.code.demo.repository.TaskRepository;

@Service
public class ImplTaskService implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<DTOTaskResponse> getAllTasks() {
        return taskRepository.findAll().stream().map(TaskMapper::toResponse).toList();
    }

    @Override
    public List<DTOTaskResponse> getAllTasksByProject(Long projectId) {
        return taskRepository.findByProject_Id(projectId).stream().map(TaskMapper::toResponse).toList();
    }

    @Override
    public DTOTaskResponse createTask(DTOTaskRequest dtoTaskRequest) {
        Project project = projectRepository.findById(dtoTaskRequest.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project no existe: " + dtoTaskRequest.getProjectId()));

        Task task = TaskMapper.toEntity(dtoTaskRequest, project);

        Task saved = taskRepository.save(task);

        return TaskMapper.toResponse(saved);

    }

    @Override
    public void deleteTaskById(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task no existe: " + id);
        }
        taskRepository.deleteById(id);
    }

}
