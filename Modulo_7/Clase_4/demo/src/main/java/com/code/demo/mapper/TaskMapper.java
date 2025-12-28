package com.code.demo.mapper;

import com.code.demo.models.dto.DTOTaskRequest;
import com.code.demo.models.dto.DTOTaskResponse;
import com.code.demo.models.entity.Project;
import com.code.demo.models.entity.Task;
import com.code.demo.models.enuModel.TaskStatus;

public class TaskMapper {
    private TaskMapper() {}

    public static Task toEntity(DTOTaskRequest req, Project project) {
        Task t = new Task();
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        t.setStatus(req.getStatus() == null ? TaskStatus.TODO : req.getStatus());
        t.setDueDate(req.getDueDate());
        t.setProject(project);
        return t;
    }

    public static DTOTaskResponse toResponse(Task t) {
        return new DTOTaskResponse(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getStatus(),
                t.getDueDate(),
                t.getProject().getId()
        );
    }
}
