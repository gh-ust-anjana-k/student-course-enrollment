package com.student_course_enrollment.backend.dto;

import com.student_course_enrollment.backend.model.EnrollmentStatus;

public class EnrollmentResponseDTO {

    private Long enrollmentId;
    private String studentName;
    private Long courseId;
    private String courseName;
    private EnrollmentStatus status;

    public EnrollmentResponseDTO(
            Long enrollmentId,
            String studentName,
            Long courseId,
            EnrollmentStatus status) {

        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
        this.courseId = courseId;
        this.status = status;
    }

    public EnrollmentResponseDTO() {

    }

    // Getters & Setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }


    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
