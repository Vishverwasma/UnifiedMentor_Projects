document.addEventListener('DOMContentLoaded', (event) => {
    // Base URL for your Spring Boot API
    const baseURL = process.env.API_BASE_URL || 'http://localhost:8080/api';
    
    // Error Handling
    const handleError = (error, customMessage = 'An error occurred. Please try again.') => {
        console.error('API request error:', error);
        alert(customMessage);
    };

    // Function to handle API requests
    const apiRequest = async (url, method, data) => {
        try {
            const response = await fetch(`${baseURL}/${url}`, {
                method,
                headers: {
                    'Content-Type': 'application/json',
                },
                body: data ? JSON.stringify(data) : null,
            });
            
            if (!response.ok) {
                const errorMessage = await response.text();
                throw new Error(errorMessage || 'Error occurred');
            }
            
            return await response.json();
        } catch (error) {
            handleError(error, 'Unable to complete the request. Please try again later.');
        }
    };

    // Generic form handler
    // script.js

// Utility function to handle form submissions
async function handleFormSubmit(formId, url, successRedirect) {
    const form = document.getElementById(formId);
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const formData = new FormData(form);
        const data = Object.fromEntries(formData.entries());
        
        try {
            const response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            if (response.ok) {
                const result = await response.json();
                console.log('Success:', result);
                if (successRedirect) {
                    window.location.href = successRedirect; // Redirect on success
                }
            } else {
                console.error('Error:', await response.text());
                alert('An error occurred. Please try again.');
            }
        } catch (error) {
            console.error('Fetch error:', error);
            alert('An error occurred. Please try again.');
        }
    });
}

// Initialize form handlers
handleFormSubmit('aptitude-test-form', '/api/test/submit', 'test-completion.html');
handleFormSubmit('college-registration-form', '/api/college/register', 'success.html');
handleFormSubmit('college-signup-form', '/api/college/signup', 'success.html');
handleFormSubmit('signup-form', '/api/admin/register', 'login.html');
handleFormSubmit('login-form', '/api/admin/login', 'dashboard.html');
handleFormSubmit('student-details-form', '/api/student/update', 'success.html');

// Function to fetch and display college options
async function fetchCollegeOptions() {
    const collegeList = document.getElementById('college-list');
    try {
        const response = await fetch('/api/college/all'); // Replace with your API endpoint
        if (response.ok) {
            const colleges = await response.json();
            collegeList.innerHTML = colleges.map(college => `<div>${college.name}</div>`).join('');
        } else {
            console.error('Error fetching colleges:', await response.text());
            collegeList.innerHTML = '<p>No colleges available.</p>';
        }
    } catch (error) {
        console.error('Fetch error:', error);
        collegeList.innerHTML = '<p>An error occurred while fetching colleges.</p>';
    }
}

// Initialize college options fetch if on the appropriate page
if (document.getElementById('college-list')) {
    fetchCollegeOptions();
}

// Function to fetch and display career options
async function fetchCareerOptions() {
    const careerOptions = document.getElementById('career-options');
    const response = await fetch('/api/career/all'); // Replace with your API endpoint
    if (response.ok) {
        const careers = await response.json();
        careerOptions.innerHTML = careers.map(career => `<li>${career.name}</li>`).join('');
    } else {
        console.error('Failed to fetch career options');
    }
}

if (document.getElementById('career-options')) {
    fetchCareerOptions();
}

// Function to handle redirection based on location
function handleLocationSelection() {
    const buttons = document.querySelectorAll('button');
    if (buttons.length > 0) {
        buttons.forEach(button => {
            button.addEventListener('click', () => {
                const location = button.textContent.toLowerCase();
                window.location.href = `college-list.html?location=${location}`;
            });
        });
    }
}

handleLocationSelection();
});