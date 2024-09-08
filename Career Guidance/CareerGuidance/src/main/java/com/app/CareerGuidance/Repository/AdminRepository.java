package com.app.CareerGuidance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.CareerGuidance.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
    @Modifying
    @Query("DELETE FROM Admin a WHERE a.username = :username")
    void deleteByUserame(String username);
    void deleteById(Long id);
}
