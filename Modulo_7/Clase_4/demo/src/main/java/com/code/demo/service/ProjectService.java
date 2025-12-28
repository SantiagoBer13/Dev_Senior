package com.code.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.code.demo.models.dto.DTOProjectRequest;
import com.code.demo.models.dto.DTOProjectResponse;

@Service
public interface ProjectService {

    List<DTOProjectResponse> getAllProjects();
    Optional<DTOProjectResponse> getProjectById(Long id);

    @PreAuthorize("hasAnyRole('ADMIN')")
    DTOProjectResponse createProject(DTOProjectRequest dtoProjectResponse);

    @PreAuthorize("hasAnyRole('ADMIN')")
    void deleteProjectById(Long id);

}
