package com.code.demo.models.dto;

import com.code.demo.models.enuModel.TypeProject;
import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOProjectRequest {

    @NotBlank
    @JsonAlias("title")
    private String name;

    @NotNull
    @JsonAlias("type_project")
    private TypeProject typeProject;

}
