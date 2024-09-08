package com.app.CareerGuidance.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Service.CollegeService;

import java.util.List;

@RestController
@RequestMapping("/api/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping("/eligible")
    public List<College> getEligibleColleges(@RequestParam double cgpa) {
        return collegeService.getEligibleColleges(cgpa);
    }
    @GetMapping("/filter")
    public List<College> getFilteredColleges(
        @RequestParam double cgpa, 
        @RequestParam double maxFees, 
        @RequestParam String location, 
        @RequestParam String ranking) {
        return collegeService.filterColleges(cgpa, maxFees, location, ranking);
    }
}