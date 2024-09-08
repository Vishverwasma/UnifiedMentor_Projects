package com.app.CareerGuidance.Model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private double cgpa;
    private String role; 
    private int entranceExamScore;
    
	public Student() {
		super();
	}

	public int getEntranceExamScore() {
		return entranceExamScore;
	}

	public void setEntranceExamScore(int entranceExamScore) {
		this.entranceExamScore = entranceExamScore;
	}

	public Student(Long id, String name, String email, String password, double cgpa, String role,
			int entranceExamScore) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cgpa = cgpa;
		this.role = role;
		this.entranceExamScore = entranceExamScore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}