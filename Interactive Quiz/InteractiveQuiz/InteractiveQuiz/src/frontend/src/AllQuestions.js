import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const AllQuestions = () => {
    const [questions, setQuestions] = useState([]);

    useEffect(() => {
        const fetchQuestions = async () => {
            try {
                const response = await axios.get('http://localhost:2215/api/questions/all');
                setQuestions(response.data);
            } catch (error) {
                console.error('Error fetching questions:', error);
            }
        };
        fetchQuestions();
    }, []);

    return (
        <div>
            <h2>All Questions</h2>
            {questions.length === 0 ? (
                <p>No questions available.</p>
            ) : (
                <ul>
                    {questions.map((question) => (
                        <li key={question.id}>
                            <h3>{question.questionText}</h3>
                            <p>Choices:</p>
                            <ul>
                                <li>A: {question.choiceA}</li>
                                <li>B: {question.choiceB}</li>
                                <li>C: {question.choiceC}</li>
                                <li>D: {question.choiceD}</li>
                            </ul>
                            <p>Correct Answer: {question.correctAnswer}</p>
                            <Link to={`/edit-question/${question.id}`}>Edit</Link>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default AllQuestions;
