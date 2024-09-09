package com.app.CareerGuidance.Controller;

import com.app.CareerGuidance.Model.CollegeRegistration;
import com.app.CareerGuidance.Service.CollegeRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class CollegeRegistrationController {

    @Autowired
    private CollegeRegistrationService collegeRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerForCollege(@RequestBody CollegeRegistration registration) {
        CollegeRegistration registered = collegeRegistrationService.registerForCollege(registration);
        return ResponseEntity.ok(registered);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelRegistration(@RequestParam Long registrationId) {
        collegeRegistrationService.cancelRegistration(registrationId);
        return ResponseEntity.ok("Registration cancelled");
    }
}
