package com.student_course_enrollment.backend.controller;

import com.student_course_enrollment.backend.dto.EnrollmentRequestDTO;
import com.student_course_enrollment.backend.dto.EnrollmentResponseDTO;
import com.student_course_enrollment.backend.model.Enrollments;
import com.student_course_enrollment.backend.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments()
    {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(@RequestBody EnrollmentRequestDTO enrollments)
    {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollments));
    }

}
