package com.app.CareerGuidance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.CareerGuidance.Model.AptitudeTestQuestion;

public interface AptitudeTestQuestionRepository extends JpaRepository<AptitudeTestQuestion, Long> {
    List<AptitudeTestQuestion> findBySection(String section);
}
