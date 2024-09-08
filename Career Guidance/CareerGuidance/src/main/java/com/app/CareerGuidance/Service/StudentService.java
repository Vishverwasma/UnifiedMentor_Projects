package com.app.CareerGuidance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.Student;
import com.app.CareerGuidance.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student login(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

	public void deleteStudent(String email) {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            studentRepository.delete(student);
        }
	}
}
