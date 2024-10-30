import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EditQuestionForm = ({ questionId, onEdit }) => {
    const [questionData, setQuestionData] = useState({
        questionText: '',
        choiceA: '',
        choiceB: '',
        choiceC: '',
        choiceD: '',
        correctAnswer: '',
        quizId: ''
    });

    useEffect(() => {
        const fetchQuestion = async () => {
            try {
                const response = await axios.get(`http://localhost:2215/api/questions/update/${questionId}`);
                setQuestionData(response.data);
            } catch (error) {
                console.error('Error fetching question data:', error);
            }
        };
        fetchQuestion();
    }, [questionId]);

    const handleChange = (e) => {
        setQuestionData({ ...questionData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.put(`http://localhost:2215/api/questions/${questionId}`, questionData);
            alert('Question updated successfully!');
            onEdit(response.data);
        } catch (error) {
            console.error('Error updating question:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Edit Question</h2>
            <input
                type="text"
                name="questionText"
                value={questionData.questionText}
                onChange={handleChange}
                placeholder="Question Text"
                required
            />
            <input
                type="text"
                name="choiceA"
                value={questionData.choiceA}
                onChange={handleChange}
                placeholder="Choice A"
                required
            />
            <input
                type="text"
                name="choiceB"
                value={questionData.choiceB}
                onChange={handleChange}
                placeholder="Choice B"
                required
            />
            <input
                type="text"
                name="choiceC"
                value={questionData.choiceC}
                onChange={handleChange}
                placeholder="Choice C"
                required
            />
            <input
                type="text"
                name="choiceD"
                value={questionData.choiceD}
                onChange={handleChange}
                placeholder="Choice D"
                required
            />
            <input
                type="text"
                name="correctAnswer"
                value={questionData.correctAnswer}
                onChange={handleChange}
                placeholder="Correct Answer (A/B/C/D)"
                required
            />
            <input
                type="text"
                name="quizId"
                value={questionData.quizId}
                onChange={handleChange}
                placeholder="Quiz ID"
                required
            />
            <button type="submit">Update Question</button>
        </form>
    );
};

export default EditQuestionForm;
