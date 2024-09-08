package com.app.CareerGuidance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Repository.CollegeRepository;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> getEligibleColleges(double cgpa) {
        return collegeRepository.findByMinCgpaLessThanEqual(cgpa);
    }
    public List<College> filterColleges(double cgpa, double maxFees, String location, String ranking) {
        return collegeRepository.filterColleges(cgpa, maxFees, location, ranking);
    }
    public List<College> filterCollegesByLocation(String location) {
        return collegeRepository.findByLocation(location);
    }

}