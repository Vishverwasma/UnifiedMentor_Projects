package com.UnifiedMentor.InteractiveQuiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UnifiedMentor.InteractiveQuiz.models.Question;
import com.UnifiedMentor.InteractiveQuiz.repositories.QuestionRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByQuizId(String quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions); // Shuffle the list to get random questions
        return questions.subList(0, Math.min(count, questions.size())); // Return the requested number of random questions
    }
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    public Question updateQuestion(Long id, Question questionDetails) throws Exception {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            question.setQuestionText(questionDetails.getQuestionText());
            question.setChoiceA(questionDetails.getChoiceA());
            question.setChoiceB(questionDetails.getChoiceB());
            question.setChoiceC(questionDetails.getChoiceC());
            question.setChoiceD(questionDetails.getChoiceD());
            question.setCorrectAnswer(questionDetails.getCorrectAnswer());
            question.setQuizId(questionDetails.getQuizId());
            return questionRepository.save(question);
        } else {
            throw new Exception("Question not found with id: " + id);
        }
    }

	public Question getQuestionById(Long id) throws Exception {
		 return questionRepository.findById(id)
		            .orElseThrow(() -> new Exception("Question not found with id: " + id));

	}
}