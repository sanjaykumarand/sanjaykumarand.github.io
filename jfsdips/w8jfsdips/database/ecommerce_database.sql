CREATE DATABASE ecommerce_management_system;
USE ecommerce_management_system;
CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100),
email VARCHAR(100),
password VARCHAR(100)
);
CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(100),
product_price VARCHAR(100),
product_category VARCHAR(100)
);
CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT,
customer_name VARCHAR(100),
product_name VARCHAR(100),
quantity VARCHAR(100)
);