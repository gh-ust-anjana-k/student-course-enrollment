package com.student_course_enrollment.backend.repository;

import com.student_course_enrollment.backend.dto.EnrollmentResponseDTO;
import com.student_course_enrollment.backend.model.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollments, Integer> {
     List<EnrollmentResponseDTO> findByCourseId(Long id);

     List<EnrollmentResponseDTO> findByStudentName(String studentName);
}
