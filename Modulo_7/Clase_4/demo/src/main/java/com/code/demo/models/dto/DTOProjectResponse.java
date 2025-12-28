package com.code.demo.models.dto;

import com.code.demo.models.enuModel.TypeProject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOProjectResponse {

    @NotBlank
    private String name;

    @NotNull
    private TypeProject typeProject;

}
