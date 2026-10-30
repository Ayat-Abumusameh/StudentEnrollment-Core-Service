package com.enrollement.enrollementStudentToCourseApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "name")
    private String name;

    // Constructors
    public Course() {}

    public Course(int courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
