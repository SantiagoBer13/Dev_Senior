package com.code.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.code.demo.Models.Course;

public interface CourseService {

    @PreAuthorize("isAuthenticated()")
    List<Course> getAllCourses();

    @PreAuthorize("isAuthenticated()")
    Optional<Course> getCourseById(Long id);

    @PreAuthorize("hasAnyRole('ADMIN')")
    Course addCourse(Course course);
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    void deleteCourse(Long id);

}
