package com.app.CareerGuidance.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.app.CareerGuidance.Model.AptitudeTestQuestion;
import com.app.CareerGuidance.Model.AptitudeTestResult;
import com.app.CareerGuidance.Repository.AptitudeTestQuestionRepository;
import com.app.CareerGuidance.Repository.AptitudeTestResultRepository;

@Service
public class AptitudeTestService {


    @Autowired
    private AptitudeTestResultRepository resultRepository;

    @Autowired
    private AptitudeTestQuestionRepository questionRepository;

    public void saveTestResult(AptitudeTestResult result) {
        resultRepository.save(result);
    }

    public List<AptitudeTestQuestion> generateTest() {
        // Example: Fetch questions for different sections
        List<AptitudeTestQuestion> verbalQuestions = questionRepository.findBySection("Verbal");
        List<AptitudeTestQuestion> quantitativeQuestions = questionRepository.findBySection("Quantitative");
        List<AptitudeTestQuestion> generalKnowledgeQuestions = questionRepository.findBySection("General Knowledge");

        // Combine all questions into a single list
        List<AptitudeTestQuestion> allQuestions = new ArrayList<>();
        allQuestions.addAll(verbalQuestions);
        allQuestions.addAll(quantitativeQuestions);
        allQuestions.addAll(generalKnowledgeQuestions);

        return allQuestions;
    } 

    public AptitudeTestQuestion addQuestion(AptitudeTestQuestion question) {
        // Logic to add question to the database
        return question;
    }
    
    public AptitudeTestResult submitResult(AptitudeTestResult result) {
    	 int score = calculateScore(result);
         result.setTotalScore(score);
         return resultRepository.save(result);
    }
    
    private int calculateScore(AptitudeTestResult result) {
        // This is a placeholder for your scoring logic
        // For example, you might check the result object and compute the score
        return 0; // Replace with actual logic
    }
    public List<AptitudeTestQuestion> getAllQuestions() {
        return questionRepository.findAll();
    }
}
