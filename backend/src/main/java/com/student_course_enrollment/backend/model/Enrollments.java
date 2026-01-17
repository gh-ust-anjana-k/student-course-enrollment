package com.student_course_enrollment.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;

    private Long courseId;

    private String courseName;

    private EnrollmentStatus status;

    public Enrollments() {
    }

    public Enrollments(int enroll_id, String student_name,String courseName, Long courseId, EnrollmentStatus status) {
        this.id = enroll_id;
        this.studentName = student_name;
        this.courseName=courseName;
        this.courseId = courseId;
        this.status = status;
    }

    public long getEnroll_id() {
        return id;
    }

    public void setEnroll_id(int enroll_id) {
        this.id = enroll_id;
    }

    public String getStudent_name() {
        return studentName;
    }

    public void setStudent_name(String student_name) {
        this.studentName = student_name;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName=courseName;
    }
}
