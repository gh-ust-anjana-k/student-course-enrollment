package com.student_course_enrollment.backend.dto;

public class CourseRequestDTO {

    private String courseName;
    private String instructor;
    private Integer duration;

    public CourseRequestDTO() {
    }

    // Getters & Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
