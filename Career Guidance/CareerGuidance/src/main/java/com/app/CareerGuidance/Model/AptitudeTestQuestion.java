package com.app.CareerGuidance.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class AptitudeTestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String section;  
    @ElementCollection 
    private List<String> options;  // multiple choice options
    private String correctAnswer;
	public AptitudeTestQuestion() {
		super();
	}
	public AptitudeTestQuestion(Long id, String question, String section, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.question = question;
		this.section = section;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

    // Getters and Setters
    
}

