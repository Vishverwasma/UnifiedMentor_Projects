import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Link, useParams  } from 'react-router-dom';
import axios from 'axios';
import './App.css'; // Assuming your main component is named App
import { useNavigate } from 'react-router-dom';

const QuestionsList = ({ questions, currentQuestionIndex, handleAnswer, answeredQuestions, selectedAnswers }) => {
  if (!questions || questions.length === 0 || currentQuestionIndex >= questions.length) {
    return <p>No questions available.</p>;
  }
  
  const question = questions[currentQuestionIndex];

  return (
    <div>
        <h2>Question {currentQuestionIndex + 1} / {questions.length}</h2>
        <p><strong>Question:</strong> {question.questionText}</p>
        <form onSubmit={(e) => e.preventDefault()}>
            <div>
                {['A', 'B', 'C', 'D'].map(choice => (
                    <label key={choice}>
                        <input 
                            type="radio" 
                            name="answer" 
                            value={choice} 
                            disabled={answeredQuestions[currentQuestionIndex]} 
                            onChange={() => handleAnswer(choice)} 
                            checked={selectedAnswers[currentQuestionIndex] === choice}
                        /> 
                        {choice}: {question[`choice${choice}`]}
                    </label>
                ))}
            </div>
        </form>
    </div>
  );
};


const EditQuestionForm = ({ onEdit }) => {
  const { questionId } = useParams();
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
      if (!questionId) return;

      try {
          const response = await axios.get(`http://localhost:2215/api/questions/question/${questionId}`);
          setQuestionData(response.data);
      } catch (error) {
          console.error('Error fetching question data:', error);
      }
    };
    fetchQuestion();
  }, [questionId]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(`http://localhost:2215/api/questions/update/${questionId}`, questionData);
      alert('Question updated successfully!');
      onEdit(response.data);
    } catch (error) {
      console.error('Error updating question:', error.response?.data || error.message);
    }
  };

  const handleChange = (e) => {
    setQuestionData({ ...questionData, [e.target.name]: e.target.value });
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

const AddQuestionForm = ({ onAdd }) => {
  const [questionText, setQuestionText] = useState('');
  const [choiceA, setChoiceA] = useState('');
  const [choiceB, setChoiceB] = useState('');
  const [choiceC, setChoiceC] = useState('');
  const [choiceD, setChoiceD] = useState('');
  const [correctAnswer, setCorrectAnswer] = useState('');
  const [quizId, setQuizId] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newQuestion = {
      questionText,
      choiceA,
      choiceB,
      choiceC,
      choiceD,
      correctAnswer,
      quizId,
    };

    try {
      const response = await axios.post('http://localhost:2215/api/questions/add-questions', newQuestion);
      onAdd(response.data);
      setMessage('Question added successfully!');
      setQuestionText('');
      setChoiceA('');
      setChoiceB('');
      setChoiceC('');
      setChoiceD('');
      setCorrectAnswer('');
      setQuizId('');
    } catch (error) {
      setMessage('Error adding question: ' + error.message);
      console.error('Error adding question:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="question-form">
      <h2>Add a New Question</h2>
      <input
          type="text"
          value={questionText}
          onChange={(e) => setQuestionText(e.target.value)}
          placeholder="Question"
          required
      />
      <input
          type="text"
          value={choiceA}
          onChange={(e) => setChoiceA(e.target.value)}
          placeholder="Choice A"
          required
      />
      <input
          type="text"
          value={choiceB}
          onChange={(e) => setChoiceB(e.target.value)}
          placeholder="Choice B"
          required
      />
      <input
          type="text"
          value={choiceC}
          onChange={(e) => setChoiceC(e.target.value)}
          placeholder="Choice C"
          required
      />
      <input
          type="text"
          value={choiceD}
          onChange={(e) => setChoiceD(e.target.value)}
          placeholder="Choice D"
          required
      />
      <input
          type="text"
          value={correctAnswer}
          onChange={(e) => setCorrectAnswer(e.target.value)}
          placeholder="Correct Answer (A/B/C/D)"
          required
      />
      <input
          type="text"
          value={quizId}
          onChange={(e) => setQuizId(e.target.value)}
          placeholder="Quiz ID"
          required
      />
      <button type="submit">Add Question</button>
      {message && <div className="message">{message}</div>}
    </form>
  );
};

const AnsweringSite = ({ questions }) => {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [score, setScore] = useState(0);
  const [answeredQuestions, setAnsweredQuestions] = useState(Array(questions.length).fill(false));
  const [selectedAnswers, setSelectedAnswers] = useState(Array(questions.length).fill(null));

  const handleAnswer = (selectedAnswer) => {
      if (answeredQuestions[currentQuestionIndex]) return;

      const question = questions[currentQuestionIndex];
      const isCorrect = selectedAnswer.toUpperCase() === question.correctAnswer;

      setSelectedAnswers(prev => {
          const newSelected = [...prev];
          newSelected[currentQuestionIndex] = selectedAnswer;
          return newSelected;
      });

      const newScore = score + (isCorrect ? 1 : -1);
      setScore(newScore);

      setAnsweredQuestions(prev => {
          const newAnswered = [...prev];
          newAnswered[currentQuestionIndex] = true;
          return newAnswered;
      });

      if (currentQuestionIndex < questions.length - 1) {
          setCurrentQuestionIndex(currentQuestionIndex + 1);
      }
  };

  const handleNext = () => {
      if (currentQuestionIndex < questions.length - 1) {
          setCurrentQuestionIndex(currentQuestionIndex + 1);
      }
  };

  const handlePrevious = () => {
      if (currentQuestionIndex > 0) {
          setCurrentQuestionIndex(currentQuestionIndex - 1);
      }
  };

  const handleSubmit = () => {
      alert(`Your final score is: ${score}`);
  };

  return (
      <div>
          <h1>Answering Site</h1>
          <QuestionsList 
              questions={questions} 
              currentQuestionIndex={currentQuestionIndex} 
              handleAnswer={handleAnswer} 
              answeredQuestions={answeredQuestions} 
              selectedAnswers={selectedAnswers} 
          />
          <div>
              <button onClick={handlePrevious} disabled={currentQuestionIndex === 0}>Previous</button>
              <button onClick={handleNext} disabled={currentQuestionIndex === questions.length - 1}>Next</button>
          </div>
          <h2>Score: {score}</h2>
          {currentQuestionIndex === questions.length - 1 && (
              <button onClick={handleSubmit}>Submit Quiz</button>
          )}
      </div>
  );
};

const AllQuestions = ({ onEdit }) => {
  const [questions, setQuestions] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchAllQuestions = async () => {
    setLoading(true);
    try {
        const response = await axios.get('http://localhost:2215/api/questions/all');
        setQuestions(response.data);
    } catch (error) {
      setError(error.response?.data?.message || 'An unexpected error occurred.');
      console.error('Error fetching questions:', error.response?.data || error.message);
    } finally {
        setLoading(false);
    }
  };

  useEffect(() => {
    fetchAllQuestions();
}, []);

if (loading) return <p>Loading...</p>;
if (error) return <p>{error}</p>;

  return (
      <div>
          <h2>All Questions</h2>
          <ul>
              {questions.map((question) => (
                  <li key={question.id}>
                      <p><strong>Question:</strong> {question.questionText}</p>
                      <p><strong>Choices:</strong></p>
                      <ul>
                          <li>A: {question.choiceA}</li>
                          <li>B: {question.choiceB}</li>
                          <li>C: {question.choiceC}</li>
                          <li>D: {question.choiceD}</li>
                      </ul>
                      <p><strong>Correct Answer:</strong> {question.correctAnswer}</p>
                      <p><strong>Quiz ID:</strong> {question.quizId}</p>
                      <Link to={`/update/${question.id}`}>
                            <button>Edit Question</button>
                        </Link>
                    </li>
              ))}
          </ul>
      </div>
  );
};

const App = () => {
  const [questions, setQuestions] = useState([]);
  const [selectedQuestionId, setSelectedQuestionId] = useState(null);
  const [editingQuestion, setEditingQuestion] = useState(null);
  const navigate = useNavigate();

  const handleAddQuestion = (newQuestion) => {
    setQuestions((prevQuestions) => [...prevQuestions, newQuestion]);
  };

    // Fetch questions from your API
    const fetchQuestions = async () => {
      try {
        const response = await axios.get('http://localhost:2215/api/questions/all');
        setQuestions(response.data);
      } catch (error) {
        console.error('Error fetching questions:', error);
      }
    };

  useEffect(() => {
      fetchQuestions();
  }, []);

  const handleEditQuestion = (updatedQuestion) => {
    setQuestions((prevQuestions) =>
      prevQuestions.map((question) =>
        question.id === updatedQuestion.id ? updatedQuestion : question
      )
    );
    setEditingQuestion(null); // Reset editing question after update
  };

  const handleEditClick = (id) => {
    setSelectedQuestionId(id);
    const questionToEdit = questions.find(q => q.id === id);
    setEditingQuestion(questionToEdit);
    navigate(`/update/${id}`);
  };
    
  const handlePrint = () => {
    const printWindow = window.open('', '_blank');
    printWindow.document.write('<html><head><title>Questions</title></head><body>');
    printWindow.document.write('<h1>Available Questions</h1>');
    questions.forEach((question, index) => {
        printWindow.document.write(`<h3>Question ${index + 1}: ${question.questionText}</h3>`);
        printWindow.document.write(`<p>A: ${question.choiceA}</p>`);
        printWindow.document.write(`<p>B: ${question.choiceB}</p>`);
        printWindow.document.write(`<p>C: ${question.choiceC}</p>`);
        printWindow.document.write(`<p>D: ${question.choiceD}</p>`);
        printWindow.document.write(`<p><strong>Correct Answer:</strong> ${question.correctAnswer}</p>`);
        printWindow.document.write('<hr/>');
    });
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.print();
};


  return (
        <div className="App">
        <h1>Quiz Management System</h1>
            <nav>
                <Link to="/">Home</Link>
                <Link to="/all-questions">All Questions</Link>
                <Link to="/add-question">Add Question</Link>
                <Link to="/answer-quiz">Take Quiz</Link>
                <button onClick={handlePrint}>Print Questions</button>
            </nav>
            <Routes>
              <Route path="/" element={<h1>Welcome to the Quiz App!</h1>} />
              <Route path="/all-questions" element={<AllQuestions onEdit={handleEditClick} />} />
              <Route path="/add-question" element={<AddQuestionForm onAdd={handleAddQuestion} />} />
              <Route path="/update/:questionId" element={<EditQuestionForm questionId={selectedQuestionId} onEdit={handleEditQuestion} />} />
              <Route path="/answer-quiz" element={<AnsweringSite questions={questions} />} />
            </Routes>
        </div>
);
};

export default App;