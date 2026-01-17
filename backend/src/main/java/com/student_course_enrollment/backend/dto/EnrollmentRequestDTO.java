package com.student_course_enrollment.backend.dto;

public class EnrollmentRequestDTO {

    private String studentName;
    private Long courseId;

    public EnrollmentRequestDTO() {
    }

    // Getters & Setters
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
}
