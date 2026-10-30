package com.enrollement.enrollementStudentToCourseApp.repository;

import com.enrollement.enrollementStudentToCourseApp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    // inside of it builtin function to deal with course table automatically
}
