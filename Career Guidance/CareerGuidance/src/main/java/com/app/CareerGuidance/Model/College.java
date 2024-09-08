package com.app.CareerGuidance.Model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class College {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String location;  // India or Abroad
    private double fees;
    private String eligibilityCriteria;
    private String scholarshipSchemes;
    private String placementOptions;
    private String ranking;
    private String housingFacilities;
    private double minCgpa;
    private int entranceExamCutoff;
	public College() {
		super();
	}

	
	public College(Long id, String name, String location, double fees, String eligibilityCriteria,
			String scholarshipSchemes, String placementOptions, String ranking, String housingFacilities,
			double minCgpa, int entranceExamCutoff) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.fees = fees;
		this.eligibilityCriteria = eligibilityCriteria;
		this.scholarshipSchemes = scholarshipSchemes;
		this.placementOptions = placementOptions;
		this.ranking = ranking;
		this.housingFacilities = housingFacilities;
		this.minCgpa = minCgpa;
		this.entranceExamCutoff = entranceExamCutoff;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}
	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}
	public String getScholarshipSchemes() {
		return scholarshipSchemes;
	}
	public void setScholarshipSchemes(String scholarshipSchemes) {
		this.scholarshipSchemes = scholarshipSchemes;
	}
	public String getPlacementOptions() {
		return placementOptions;
	}
	public void setPlacementOptions(String placementOptions) {
		this.placementOptions = placementOptions;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getHousingFacilities() {
		return housingFacilities;
	}
	public void setHousingFacilities(String housingFacilities) {
		this.housingFacilities = housingFacilities;
	}


	public double getMinCgpa() {
		return minCgpa;
	}


	public void setMinCgpa(double minCgpa) {
		this.minCgpa = minCgpa;
	}


	public int getEntranceExamCutoff() {
		return entranceExamCutoff;
	}


	public void setEntranceExamCutoff(int entranceExamCutoff) {
		this.entranceExamCutoff = entranceExamCutoff;
	}

    // Getters and Setters
    
}
