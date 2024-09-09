package com.app.CareerGuidance.Controller;

import com.app.CareerGuidance.Model.AptitudeTestQuestion;
import com.app.CareerGuidance.Model.AptitudeTestResult;
import com.app.CareerGuidance.Service.AptitudeTestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aptitudetest")
public class AptitudeTestController {
    
    @Autowired
    private AptitudeTestService aptitudeTestService;

    @PostMapping("/questions")
    public ResponseEntity<?> addAptitudeTestQuestion(@RequestBody AptitudeTestQuestion question) {
        AptitudeTestQuestion savedQuestion = aptitudeTestService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitAptitudeTestResult(@RequestBody AptitudeTestResult result) {
        AptitudeTestResult savedResult = aptitudeTestService.submitResult(result);
        return ResponseEntity.ok(savedResult);
    }
    
    @GetMapping("/questions")
    public List<AptitudeTestQuestion> getAllQuestions() {
        return aptitudeTestService.getAllQuestions();
    }
}
