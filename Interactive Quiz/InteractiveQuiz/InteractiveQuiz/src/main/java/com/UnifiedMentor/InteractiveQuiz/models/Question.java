package com.UnifiedMentor.InteractiveQuiz.models;

import jakarta.persistence.*;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = {"quizId", "questionText"})})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quizId")
	private String quizId;
	
	@Column(name = "questionText")
    private String questionText;
    
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;

    @Column(name = "correctAnswer")
    private char correctAnswer;

	public Long getId() {
		return id;
	}
    public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getChoiceA() {
		return choiceA;
	}
	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}
	public String getChoiceB() {
		return choiceB;
	}
	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}
	public String getChoiceC() {
		return choiceC;
	}
	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}
	public String getChoiceD() {
		return choiceD;
	}
	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	public char getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(char correctAnswer) {
		this.correctAnswer = Character.toUpperCase(correctAnswer);
	}
	public Question() {
		super();
	}
	public Question(Long id,String quizId , String questionText, String choiceA, String choiceB, String choiceC, String choiceD,
			char correctAnswer) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.questionText = questionText;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.correctAnswer = correctAnswer;
	}
}
