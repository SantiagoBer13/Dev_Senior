package com.code.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.demo.Models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {
    
}
