package com.enrollement.enrollementStudentToCourseApp.repository;

import com.enrollement.enrollementStudentToCourseApp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    // inside of it builtin function to save and delete details of enrollment student in subjects
}
