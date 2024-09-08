package com.app.CareerGuidance.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.CareerGuidance.Model.Student;
import com.app.CareerGuidance.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping("/login")
    public Student loginStudent(@RequestParam String email, @RequestParam String password) {
        return studentService.login(email, password);
    }
}
