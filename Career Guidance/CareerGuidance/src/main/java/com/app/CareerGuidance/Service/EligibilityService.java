package com.app.CareerGuidance.Service;

import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Model.Student;

@Service
public class EligibilityService {
	public boolean checkEligibility(Student student, College college) {
	    if (student == null || college == null) {
	        throw new IllegalArgumentException("Student or College cannot be null");
	    }
	    System.out.println("Student CGPA: " + student.getCgpa());
	    System.out.println("College Min CGPA: " + college.getMinCgpa());
	    System.out.println("Student Entrance Exam Score: " + student.getEntranceExamScore());
	    System.out.println("College Entrance Exam Cutoff: " + college.getEntranceExamCutoff());
	    
	    return student.getCgpa() >= college.getMinCgpa() &&
	           student.getEntranceExamScore() >= college.getEntranceExamCutoff();
	}

}
