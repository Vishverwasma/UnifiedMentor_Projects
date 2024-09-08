package com.app.CareerGuidance.Model;

import jakarta.persistence.*;

@Entity
public class AptitudeTestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double verbalScore;
    private double quantitativeScore;
    private double generalKnowledgeScore;
    private double totalScore;

    @ManyToOne
    private Student student;

	public AptitudeTestResult(Long id, double verbalScore, double quantitativeScore, double generalKnowledgeScore,
			double totalScore, Student student) {
		super();
		this.id = id;
		this.verbalScore = verbalScore;
		this.quantitativeScore = quantitativeScore;
		this.generalKnowledgeScore = generalKnowledgeScore;
		this.totalScore = totalScore;
		this.student = student;
	}

	public AptitudeTestResult() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getVerbalScore() {
		return verbalScore;
	}

	public void setVerbalScore(double verbalScore) {
		this.verbalScore = verbalScore;
	}

	public double getQuantitativeScore() {
		return quantitativeScore;
	}

	public void setQuantitativeScore(double quantitativeScore) {
		this.quantitativeScore = quantitativeScore;
	}

	public double getGeneralKnowledgeScore() {
		return generalKnowledgeScore;
	}

	public void setGeneralKnowledgeScore(double generalKnowledgeScore) {
		this.generalKnowledgeScore = generalKnowledgeScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}