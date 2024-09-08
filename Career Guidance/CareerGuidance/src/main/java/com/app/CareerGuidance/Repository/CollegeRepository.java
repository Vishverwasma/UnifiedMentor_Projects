package com.app.CareerGuidance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.CareerGuidance.Model.College;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long> {
    List<College> findByMinCgpaLessThanEqual(double cgpa);
    @Query("SELECT c FROM College c WHERE c.minCgpa <= :cgpa AND c.fees <= :maxFees AND c.location = :location AND c.ranking = :ranking")
    List<College> filterColleges(@Param("cgpa") double cgpa, 
                                 @Param("maxFees") double maxFees, 
                                 @Param("location") String location, 
                                 @Param("ranking") String ranking);
    List<College> findByLocation(String location);
}