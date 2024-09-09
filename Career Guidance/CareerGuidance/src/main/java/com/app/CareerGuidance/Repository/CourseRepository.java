package com.app.CareerGuidance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.CareerGuidance.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
