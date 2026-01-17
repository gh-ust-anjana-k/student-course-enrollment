package com.student_course_enrollment.backend.controller;

import com.student_course_enrollment.backend.model.Courses;
import com.student_course_enrollment.backend.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses()
    {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

}
