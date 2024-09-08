package com.app.CareerGuidance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.CareerGuidance.Model.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
