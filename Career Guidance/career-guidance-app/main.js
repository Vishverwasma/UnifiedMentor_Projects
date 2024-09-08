// main.js

// Function to handle login
async function handleLogin() {
    const form = document.getElementById('login-form');
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const formData = new FormData(form);
        const data = Object.fromEntries(formData.entries());
        
        try {
            const response = await fetch('/api/admin/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            if (response.ok) {
                const result = await response.json();
                console.log('Login Successful:', result);
                window.location.href = 'dashboard.html'; // Redirect to a dashboard or home page
            } else {
                console.error('Login Failed:', await response.text());
                alert('Invalid credentials. Please try again.');
            }
        } catch (error) {
            console.error('Fetch error:', error);
            alert('An error occurred. Please try again.');
        }
    });
}

// Function to handle signup
async function handleSignup() {
    const form = document.getElementById('signup-form');
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        const formData = new FormData(form);
        const data = Object.fromEntries(formData.entries());
        
        try {
            const response = await fetch('/api/admin/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            if (response.ok) {
                const result = await response.json();
                console.log('Signup Successful:', result);
                window.location.href = 'login.html'; // Redirect to login page
            } else {
                console.error('Signup Failed:', await response.text());
                alert('Registration failed. Please try again.');
            }
        } catch (error) {
            console.error('Fetch error:', error);
            alert('An error occurred. Please try again.');
        }
    });
}

// Initialize login and signup handlers
if (document.getElementById('login-form')) {
    handleLogin();
}

if (document.getElementById('signup-form')) {
    handleSignup();
}
