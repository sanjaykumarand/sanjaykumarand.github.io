CREATE DATABASE student_management;
USE student_management;
CREATE TABLE students (
	id INT PRIMARY KEY AUTO_INCREMENT,
	student_name VARCHAR(100),
	department VARCHAR(100),
	email VARCHAR(100)
);