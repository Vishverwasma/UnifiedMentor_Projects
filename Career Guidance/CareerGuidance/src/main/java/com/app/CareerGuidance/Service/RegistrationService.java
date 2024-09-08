package com.app.CareerGuidance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.CollegeRegistration;
import com.app.CareerGuidance.Repository.CollegeRegistrationRepository;

@Service
public class RegistrationService {
    @Autowired
    private CollegeRegistrationRepository registrationRepository;

    public CollegeRegistration registerForCollege(CollegeRegistration registration) {
        return registrationRepository.save(registration);
    }
}

