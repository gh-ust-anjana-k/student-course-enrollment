package com.student_course_enrollment.backend.service;

import com.student_course_enrollment.backend.model.Courses;
import com.student_course_enrollment.backend.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Courses> getCourse(Long id) {
        return courseRepository.findById(id);
    }

    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }

    public Courses updateCourse(Long id, Courses updatedCourse) {
        Courses existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existing.setCourseName(updatedCourse.getCourseName());
        existing.setInstructor(updatedCourse.getInstructor());
        existing.setDuration(updatedCourse.getDuration());

        return courseRepository.save(existing);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
