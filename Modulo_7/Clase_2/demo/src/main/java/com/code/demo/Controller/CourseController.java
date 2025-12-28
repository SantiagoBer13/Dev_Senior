package com.code.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.demo.Models.Course;
import com.code.demo.Service.ImplCourseService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    @Autowired
    private ImplCourseService implCourseService;

    @GetMapping("")
    public List<Course> getAllCourses() {
        return implCourseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> GetCourseById(@PathVariable Long id) {
        return implCourseService.getCourseById(id);
    }

    @PostMapping("")
    public Course addCourse(@RequestBody Course entity) {
        return implCourseService.addCourse(entity);
    }
    
    @DeleteMapping("/{id}")
    public void DeleteCourseById(@PathVariable Long id) {
        implCourseService.deleteCourse(id);
    }

}
