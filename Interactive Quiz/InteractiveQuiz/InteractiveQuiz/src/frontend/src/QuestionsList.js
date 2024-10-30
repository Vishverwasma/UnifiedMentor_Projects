import React, { useState } from 'react';

const QuestionsList = ({ questions, onEditQuestion }) => {
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
    const [score, setScore] = useState(0);
    const [answeredQuestions, setAnsweredQuestions] = useState(Array(questions.length).fill(false));
    const [selectedAnswers, setSelectedAnswers] = useState(Array(questions.length).fill(null));

    const handleAnswer = (selectedAnswer) => {
        if (answeredQuestions[currentQuestionIndex]) return;

        const question = questions[currentQuestionIndex];
        const isCorrect = selectedAnswer === question.correctAnswer;

        setSelectedAnswers((prev) => {
            const newSelected = [...prev];
            newSelected[currentQuestionIndex] = selectedAnswer;
            return newSelected;
        });

        const newScore = score + (isCorrect ? 1 : -1);
        setScore(newScore);

        setAnsweredQuestions((prev) => {
            const newAnswered = [...prev];
            newAnswered[currentQuestionIndex] = true;
            return newAnswered;
        });

        if (currentQuestionIndex < questions.length - 1) {
            setCurrentQuestionIndex(currentQuestionIndex + 1);
        }
    };

    return (
        <div>
            <h1>Answering Site</h1>
            {questions.length === 0 ? (
                <p>No questions available.</p>
            ) : (
                <div>
                    <h2>Question {currentQuestionIndex + 1} / {questions.length}</h2>
                    <p><strong>Question:</strong> {questions[currentQuestionIndex].questionText}</p>
                    <form onSubmit={(e) => e.preventDefault()}>
                        {['A', 'B', 'C', 'D'].map((choice) => (
                            <label key={choice}>
                                <input
                                    type="radio"
                                    name="answer"
                                    value={choice}
                                    disabled={answeredQuestions[currentQuestionIndex]}
                                    onChange={() => handleAnswer(choice)}
                                    checked={selectedAnswers[currentQuestionIndex] === choice}
                                />
                                {choice}: {questions[currentQuestionIndex][`choice${choice}`]}
                            </label>
                        ))}
                    </form>
                    <h2>Score: {score}</h2>
                </div>
            )}
        </div>
    );
};

export default QuestionsList;
