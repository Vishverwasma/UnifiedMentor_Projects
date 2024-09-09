package com.app.CareerGuidance.Service;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Repository.CollegeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerGuidanceService {

    @Autowired
    private CollegeRepository collegeRepository;
    
    public String getCareerAdvice(double cgpa, int entranceExamScore) {
        if (cgpa > 8.0 && entranceExamScore > 90) {
            return "You have a great chance for top-tier colleges.";
        }
        return "Consider improving your scores for better opportunities.";
    }

    public List<College> getCollegeRecommendations(double cgpa, int entranceExamScore) {
        // Fetch college recommendations based on the student's performance
        if (cgpa > 8.0 && entranceExamScore > 90) {
            // Fetch colleges for high scores (e.g., top-tier colleges)
            return collegeRepository.findCollegesByRankingRange(1, 10); // Example of filtering colleges by rank
        } else if (cgpa > 7.0 && entranceExamScore > 75) {
            // Fetch mid-tier colleges
            return collegeRepository.findCollegesByRankingRange(11, 50);
        } else {
            // Fetch colleges for lower scores
            return collegeRepository.findCollegesByRankingRange(51, 100);
        }
    }
}
