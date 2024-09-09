package com.app.CareerGuidance.Service;

import com.app.CareerGuidance.Model.Course;
import com.app.CareerGuidance.Repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course registerCourse(Course course) {
        // Logic for registering the course in the database
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        // Logic for fetching all available courses
        return courseRepository.findAll();
    }

    public void deleteCourse(Long id) {
        // Logic for deleting the course by ID
        courseRepository.deleteById(id);
    }
}
