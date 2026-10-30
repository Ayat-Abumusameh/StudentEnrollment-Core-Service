package com.enrollement.enrollementStudentToCourseApp.service;

import com.enrollement.enrollementStudentToCourseApp.model.Enrollment;
import com.enrollement.enrollementStudentToCourseApp.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(int id) {
        enrollmentRepository.deleteById(id);
    }

    // function to search and update if we want lately
    public Enrollment getEnrollmentById(int id) {
        return enrollmentRepository.findById(id).orElse(null);
    }
}
