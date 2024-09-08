package com.app.CareerGuidance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.College;
import com.app.CareerGuidance.Repository.CollegeRepository;

import java.util.List;
import java.util.Optional;

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
	public College addCollege(College college) {
        if (college == null) {
            throw new IllegalArgumentException("College cannot be null");
        }
        return collegeRepository.save(college);
	}
	public College updateCollege(College college) {
        if (college == null || college.getId() == null) {
            throw new IllegalArgumentException("College or College ID cannot be null");
        }

        // Fetch the existing college from the database
        Optional<College> optionalExistingCollege = collegeRepository.findById(college.getId());
        if (!optionalExistingCollege.isPresent()) {
            throw new IllegalArgumentException("College with ID " + college.getId() + " does not exist");
        }

        // Get the existing college
        College existingCollege = optionalExistingCollege.get();

        // Update the existing college details with the new values
        existingCollege.setName(college.getName());
        existingCollege.setLocation(college.getLocation());
        existingCollege.setFees(college.getFees());
        existingCollege.setEligibilityCriteria(college.getEligibilityCriteria());
        existingCollege.setScholarshipSchemes(college.getScholarshipSchemes());
        existingCollege.setPlacementOptions(college.getPlacementOptions());
        existingCollege.setRanking(college.getRanking());
        existingCollege.setHousingFacilities(college.getHousingFacilities());
        existingCollege.setMinCgpa(college.getMinCgpa());
        existingCollege.setEntranceExamCutoff(college.getEntranceExamCutoff());

        // Save the updated college back to the database
        return collegeRepository.save(existingCollege);
	}
	public void deleteCollege(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("College ID cannot be null");
        }
        if (!collegeRepository.existsById(id)) {
            throw new IllegalArgumentException("College with ID " + id + " does not exist");
        }
        collegeRepository.deleteById(id);
	}

}