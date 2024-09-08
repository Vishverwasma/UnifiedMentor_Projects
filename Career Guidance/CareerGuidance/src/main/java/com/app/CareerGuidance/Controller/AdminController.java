package com.app.CareerGuidance.Controller;

import com.app.CareerGuidance.Model.Admin;
import com.app.CareerGuidance.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password) {
        // Example logic for registration
        // Check if username already exists
        Admin existingAdmin = adminService.getAdminByUsername(username);
        if (existingAdmin != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        // Create new admin
        Admin newAdmin = new Admin();
        newAdmin.setUsername(username);
        newAdmin.setPassword(password); // Consider encrypting passwords in real applications

        Admin savedAdmin = adminService.saveAdmin(newAdmin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) {
        Admin updatedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(updatedAdmin);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAdmin(@RequestParam String username) {
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null) {
            adminService.deleteAdmin(username);
            return ResponseEntity.ok("Admin deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin not found");
    }

}
