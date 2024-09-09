package com.app.CareerGuidance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.CareerGuidance.Model.Course;
import com.app.CareerGuidance.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCourse(@RequestBody Course course) {
        Course registeredCourse = courseService.registerCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredCourse);
    }

    @GetMapping("/list")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
