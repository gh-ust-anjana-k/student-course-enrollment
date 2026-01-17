package com.student_course_enrollment.backend.service;

import com.student_course_enrollment.backend.dto.EnrollmentRequestDTO;
import com.student_course_enrollment.backend.dto.EnrollmentResponseDTO;
import com.student_course_enrollment.backend.model.EnrollmentStatus;
import com.student_course_enrollment.backend.model.Enrollments;
import com.student_course_enrollment.backend.repository.EnrollmentRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<EnrollmentResponseDTO> getAllEnrollments() {

        List<Enrollments> enrollments = enrollmentRepository.findAll();

        return enrollments.stream().map(enrollment -> {
            EnrollmentResponseDTO dto = new EnrollmentResponseDTO();
            dto.setEnrollmentId(enrollment.getEnroll_id());
            dto.setStudentName(enrollment.getStudent_name());
            dto.setCourseId(enrollment.getCourseId());
            dto.setStatus(enrollment.getStatus());
            return dto;
        }).toList();
    }


    public List<EnrollmentResponseDTO> getCourseEnrollments(Long id) {
        return enrollmentRepository.findByCourseId(id);
    }

    public List<EnrollmentResponseDTO> getEnrolledStudents(String studentName) {
        return enrollmentRepository.findByStudentName(studentName);
    }

    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto) {

        Enrollments enrollment = new Enrollments();
        enrollment.setStudent_name(dto.getStudentName());
        enrollment.setCourseId(dto.getCourseId());
        enrollment.setStatus(EnrollmentStatus.ENROLLED);

        Enrollments saved = enrollmentRepository.save(enrollment);

        return new EnrollmentResponseDTO(
                saved.getEnroll_id(),
                saved.getStudent_name(),
                saved.getCourseId(),
                saved.getStatus()
        );

    }

}
