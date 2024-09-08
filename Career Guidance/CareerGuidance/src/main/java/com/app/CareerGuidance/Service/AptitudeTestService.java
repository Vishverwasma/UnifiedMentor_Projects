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
}
