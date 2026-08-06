CREATE DATABASE employee_management;
USE employee_management;
CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	employee_name VARCHAR(100),
	department VARCHAR(100),
	salary VARCHAR(100)
);