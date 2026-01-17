package com.student_course_enrollment.backend.repository;

import com.student_course_enrollment.backend.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Long> {

}
