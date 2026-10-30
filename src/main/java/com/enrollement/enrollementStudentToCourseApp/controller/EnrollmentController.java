package com.enrollement.enrollementStudentToCourseApp.controller;

import com.enrollement.enrollementStudentToCourseApp.model.Enrollment;
import com.enrollement.enrollementStudentToCourseApp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.saveEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollmentDetails) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment != null) {
            enrollment.setStudentId(enrollmentDetails.getStudentId());
            enrollment.setCourseId(enrollmentDetails.getCourseId());
            enrollment.setEnrollmentDate(enrollmentDetails.getEnrollmentDate());
            return enrollmentService.saveEnrollment(enrollment);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable int id) {
        enrollmentService.deleteEnrollment(id);
        return "Cancel enrollment student to course done successfully!";
    }
}
