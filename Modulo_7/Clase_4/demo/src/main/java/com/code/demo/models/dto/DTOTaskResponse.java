package com.code.demo.models.dto;

import java.time.LocalDateTime;

import com.code.demo.models.entity.Project;
import com.code.demo.models.enuModel.TaskStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOTaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    @JsonProperty("due_date")
    private LocalDateTime dueDate;
    @JsonProperty("project_id")
    private Long projectId;

}
