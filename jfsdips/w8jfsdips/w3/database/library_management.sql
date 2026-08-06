CREATE DATABASE library_management;
USE library_management;
CREATE TABLE books (
id INT PRIMARY KEY AUTO_INCREMENT,
book_name VARCHAR(100),
author_name VARCHAR(100),
category VARCHAR(100)
);