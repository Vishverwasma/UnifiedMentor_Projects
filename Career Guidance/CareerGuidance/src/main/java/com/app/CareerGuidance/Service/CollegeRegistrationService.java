package com.app.CareerGuidance.Service;

import com.app.CareerGuidance.Model.CollegeRegistration;
import com.app.CareerGuidance.Repository.CollegeRegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeRegistrationService {

    @Autowired
    private CollegeRegistrationRepository registrationRepository;

    public CollegeRegistration registerForCollege(CollegeRegistration registration) {
        // Logic to verify and register a student for a college
        // You might include validation logic here if needed
        return registrationRepository.save(registration);
    }

    public void cancelRegistration(Long registrationId) {
        // Logic to cancel the registration
        registrationRepository.deleteById(registrationId);
    }
}
