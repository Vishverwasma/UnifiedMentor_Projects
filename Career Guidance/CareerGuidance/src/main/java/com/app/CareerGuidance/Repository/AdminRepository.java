package com.app.CareerGuidance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.app.CareerGuidance.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
