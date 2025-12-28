package com.code.demo.mapper;

import com.code.demo.models.dto.DTOProjectRequest;
import com.code.demo.models.dto.DTOProjectResponse;
import com.code.demo.models.entity.Project;

public class ProjectMapper {
    private ProjectMapper() {}

    /** Request -> Entity (para crear) */
    public static Project toEntity(DTOProjectRequest req) {
        if (req == null) return null;

        Project p = new Project();
        p.setName(req.getName());
        p.setTypeProject(req.getTypeProject());
        return p;
    }

    /** Entity -> Response */
    public static DTOProjectResponse toResponse(Project p) {
        if (p == null) return null;

        DTOProjectResponse res = new DTOProjectResponse();
        res.setName(p.getName());
        res.setTypeProject(p.getTypeProject());
        return res;
    }

    /** (Opcional) para update: aplica campos del request sobre una entidad existente */
    public static void updateEntity(Project target, DTOProjectRequest req) {
        if (target == null || req == null) return;

        target.setName(req.getName());
        target.setTypeProject(req.getTypeProject());
    }
}
