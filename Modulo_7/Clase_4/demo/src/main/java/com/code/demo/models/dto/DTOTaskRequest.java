package com.code.demo.models.dto;

import java.time.LocalDateTime;

import com.code.demo.models.entity.Project;
import com.code.demo.models.enuModel.TaskStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOTaskRequest {

    @NotBlank
    private String title;

    private String description;

    private TaskStatus status = TaskStatus.TODO;

    @NotNull
    @JsonAlias("due_date")
    private LocalDateTime dueDate;

    @NotNull
    @JsonProperty("project_id")
    @JsonAlias({"projectId"})
    private Long projectId;

}
