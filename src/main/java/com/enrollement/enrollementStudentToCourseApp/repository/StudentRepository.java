package com.enrollement.enrollementStudentToCourseApp.repository;

import com.enrollement.enrollementStudentToCourseApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // inside of it builtin function like: save(), findAll(), findById(), deleteById()
}
