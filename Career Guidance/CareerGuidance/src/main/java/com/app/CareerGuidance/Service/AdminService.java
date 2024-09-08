package com.app.CareerGuidance.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CareerGuidance.Model.Admin;
import com.app.CareerGuidance.Repository.AdminRepository;
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
	public void deleteAdmin(String username) {
	    Admin admin = adminRepository.findByUsername(username);
	    if (admin != null) {
	        adminRepository.delete(admin);
	    }
	}

}
