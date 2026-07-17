CREATE DATABASE food_ordering_system;
USE food_ordering_system;
CREATE TABLE food_orders (
id INT PRIMARY KEY AUTO_INCREMENT,
customer_name VARCHAR(100),
food_item VARCHAR(100),
quantity VARCHAR(50),
address VARCHAR(200)
);