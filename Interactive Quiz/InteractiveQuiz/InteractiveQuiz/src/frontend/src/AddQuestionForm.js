import React, { useState } from 'react';
import axios from 'axios';

const AddQuestionForm = ({ onAdd }) => {
    const [questionData, setQuestionData] = useState({
        questionText: '',
        choiceA: '',
        choiceB: '',
        choiceC: '',
        choiceD: '',
        correctAnswer: '',
        quizId: ''
    });
    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        setQuestionData({ ...questionData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:2215/api/questions/add-questions', questionData);
            onAdd(response.data);
            setMessage('Question added successfully!');
            setQuestionData({
                questionText: '',
                choiceA: '',
                choiceB: '',
                choiceC: '',
                choiceD: '',
                correctAnswer: '',
                quizId: ''
            });
        } catch (error) {
            setMessage('Error adding question: ' + error.message);
            console.error('Error adding question:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>Add a New Question</h2>
            <input type="text" name="questionText" value={questionData.questionText} onChange={handleChange} placeholder="Question" required />
            <input type="text" name="choiceA" value={questionData.choiceA} onChange={handleChange} placeholder="Choice A" required />
            <input type="text" name="choiceB" value={questionData.choiceB} onChange={handleChange} placeholder="Choice B" required />
            <input type="text" name="choiceC" value={questionData.choiceC} onChange={handleChange} placeholder="Choice C" required />
            <input type="text" name="choiceD" value={questionData.choiceD} onChange={handleChange} placeholder="Choice D" required />
            <input type="text" name="correctAnswer" value={questionData.correctAnswer} onChange={handleChange} placeholder="Correct Answer (A/B/C/D)" required />
            <input type="text" name="quizId" value={questionData.quizId} onChange={handleChange} placeholder="Quiz ID" required />
            <button type="submit">Add Question</button>
            {message && <div>{message}</div>}
        </form>
    );
};

export default AddQuestionForm;
