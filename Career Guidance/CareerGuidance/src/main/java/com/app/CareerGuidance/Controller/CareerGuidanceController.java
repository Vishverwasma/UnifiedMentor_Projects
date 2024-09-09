package com.app.CareerGuidance.Controller;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Service.CareerGuidanceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/careerguidance")
public class CareerGuidanceController {
    
    @Autowired
    private CareerGuidanceService careerGuidanceService;

    @GetMapping("/advice")
    public ResponseEntity<?> getCareerAdvice(@RequestParam double cgpa, @RequestParam int entranceExamScore) {
        String advice = careerGuidanceService.getCareerAdvice(cgpa, entranceExamScore);
        return ResponseEntity.ok(advice);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<?> getCollegeRecommendations(@RequestParam double cgpa, @RequestParam int entranceExamScore) {
        List<College> colleges = careerGuidanceService.getCollegeRecommendations(cgpa, entranceExamScore);
        return ResponseEntity.ok(colleges);
    }
}
