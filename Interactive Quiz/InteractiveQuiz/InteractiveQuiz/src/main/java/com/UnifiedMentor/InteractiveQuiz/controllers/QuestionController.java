package com.UnifiedMentor.InteractiveQuiz.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.UnifiedMentor.InteractiveQuiz.models.Question;
import com.UnifiedMentor.InteractiveQuiz.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }


    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable String quizId) {
        return questionService.getQuestionsByQuizId(quizId);
    }

    @GetMapping("/question/{id}") // New GetMapping to fetch question by ID
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        try {
            Question question = questionService.getQuestionById(id);
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }
    
    @PostMapping("/add-questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
    	try {
            Question savedQuestion = questionService.saveQuestion(question);
            return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Return 500 status on error
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        try {
            Question updatedQuestion = questionService.updateQuestion(id, questionDetails);
            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/all-questions")
    public void printQuestions(List<Question> questions) {
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestionText());
            System.out.println("A: " + question.getChoiceA());
            System.out.println("B: " + question.getChoiceB());
            System.out.println("C: " + question.getChoiceC());
            System.out.println("D: " + question.getChoiceD());
            System.out.println("Correct Answer: " + question.getCorrectAnswer());
            System.out.println();
        }
    }

}