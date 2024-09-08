package com.app.CareerGuidance.Model;

import jakarta.persistence.*;

@Entity
public class CollegeRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private College college;

    private double cgpa;
    private double entranceExamScore;
    private double aptitudeTestScore;
	public CollegeRegistration() {
		super();
	}
	public CollegeRegistration(Long id, Student student, College college, double cgpa, double entranceExamScore,
			double aptitudeTestScore) {
		super();
		this.id = id;
		this.student = student;
		this.college = college;
		this.cgpa = cgpa;
		this.entranceExamScore = entranceExamScore;
		this.aptitudeTestScore = aptitudeTestScore;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public double getEntranceExamScore() {
		return entranceExamScore;
	}
	public void setEntranceExamScore(double entranceExamScore) {
		this.entranceExamScore = entranceExamScore;
	}
	public double getAptitudeTestScore() {
		return aptitudeTestScore;
	}
	public void setAptitudeTestScore(double aptitudeTestScore) {
		this.aptitudeTestScore = aptitudeTestScore;
	}

}
