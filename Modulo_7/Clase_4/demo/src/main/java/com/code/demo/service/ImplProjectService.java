package com.code.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.demo.exception.exceptions.ProjectAlreadyExistsException;
import com.code.demo.mapper.ProjectMapper;
import com.code.demo.models.dto.DTOProjectRequest;
import com.code.demo.models.dto.DTOProjectResponse;
import com.code.demo.models.entity.Project;
import com.code.demo.repository.ProjectRepository;

@Service
public class ImplProjectService implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<DTOProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream().map(ProjectMapper::toResponse).toList();
    }

    @Override
    public Optional<DTOProjectResponse> getProjectById(Long id) {
        return projectRepository.findById(id).map(ProjectMapper::toResponse);
    }

    @Override
    public DTOProjectResponse createProject(DTOProjectRequest dtoProjectRequest) {

        Optional<Project> projectSearched = projectRepository.findByName(dtoProjectRequest.getName());
        if(projectSearched.isPresent()){
            throw new ProjectAlreadyExistsException(dtoProjectRequest.getName());
        }
        Project project = ProjectMapper.toEntity(dtoProjectRequest);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toResponse(saved);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    

}
