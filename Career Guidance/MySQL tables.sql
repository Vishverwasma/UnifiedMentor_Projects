create database UnifiedMentorProjects;

use UnifiedMentorProjects;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(100),
    role ENUM('STUDENT', 'ADMIN'),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE colleges (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location ENUM('INDIA', 'ABROAD'),
    ranking INT,
    fee DECIMAL(10, 2),
    eligibility VARCHAR(255),
    housing_facilities BOOLEAN,
    scholarship BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE student_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    cgpa DECIMAL(3, 2),
    entrance_exam_score DECIMAL(4, 2),
    field_of_interest VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE aptitude_test (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255),
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    correct_option INT
);

CREATE TABLE test_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    score INT,
    test_completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES users(id)
);

