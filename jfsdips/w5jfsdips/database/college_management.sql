CREATE DATABASE college_management;
USE college_management;
CREATE TABLE students (
id INT PRIMARY KEY AUTO_INCREMENT,
student_name VARCHAR(100),
department VARCHAR(100),
email VARCHAR(100)
);
CREATE TABLE faculty (
id INT PRIMARY KEY AUTO_INCREMENT,
faculty_name VARCHAR(100),
subject_name VARCHAR(100),
email VARCHAR(100)
);