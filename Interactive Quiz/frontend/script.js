document.addEventListener("DOMContentLoaded", () => {
    const quizContainer = document.getElementById("quiz-questions");
    const submitButton = document.getElementById("submit-btn");
    const prevButton = document.getElementById("prev-btn");
    const nextButton = document.getElementById("next-btn");
    const resultContainer = document.getElementById("result");
    
    let questionsData = []; // To store the fetched questions
    let currentQuestionIndex = 0; // Track the current question index
    let score = 0; // Track the user's score

    const numberOfQuestions = 10; // Set the number of random questions to fetch

    // Fetch random quiz questions from the backend
    fetch(`http://localhost:2215/api/questions/random/${numberOfQuestions}`)
        .then(response => response.json())
        .then(data => {
            questionsData = data; // Store the fetched questions
            displayQuestion(currentQuestionIndex); // Display the first question
        })
        .catch(error => {
            console.error("Error fetching questions:", error);
            resultContainer.innerHTML = "Failed to load quiz questions. Please try again later.";
        });

    function displayQuestion(index) {
        const question = questionsData[index];
        quizContainer.innerHTML = `
            <div class="question">
                <p>${index + 1}. ${question.questionText}</p>
                <label><input type="radio" name="answer" value="A"> ${question.choiceA}</label><br>
                <label><input type="radio" name="answer" value="B"> ${question.choiceB}</label><br>
                <label><input type="radio" name="answer" value="C"> ${question.choiceC}</label><br>
                <label><input type="radio" name="answer" value="D"> ${question.choiceD}</label>
            </div>
        `;
        prevButton.disabled = index === 0; // Disable prev button on first question
        nextButton.disabled = index === questionsData.length - 1; // Disable next button on last question
    }

    submitButton.addEventListener("click", () => {
        const answer = document.querySelector('input[name="answer"]:checked');
        // Check the selected answer against the correct answer from the fetched data
        if (answer && answer.value === questionsData[currentQuestionIndex].correctAnswer) {
            score++;
        }
        alert(`You selected ${answer ? answer.value : 'nothing'} for question ${currentQuestionIndex + 1}`);
    });

    prevButton.addEventListener("click", () => {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion(currentQuestionIndex);
        }
    });

    nextButton.addEventListener("click", () => {
        if (currentQuestionIndex < questionsData.length - 1) {
            currentQuestionIndex++;
            displayQuestion(currentQuestionIndex);
        }
    });
});
