package com.UnifiedMentor.InteractiveQuiz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UnifiedMentor.InteractiveQuiz.models.Question;

public interface QuestionRepository extends JpaRepository<Question , Long> {
    List<Question> findByQuizId(String quizId);
}
