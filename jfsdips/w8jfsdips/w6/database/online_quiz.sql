CREATE DATABASE online_quiz_system;
USE online_quiz_system;
CREATE TABLE questions (
id INT PRIMARY KEY AUTO_INCREMENT,
question VARCHAR(255),
option1 VARCHAR(100),
option2 VARCHAR(100),
option3 VARCHAR(100),
option4 VARCHAR(100),
correct_answer VARCHAR(100)
);