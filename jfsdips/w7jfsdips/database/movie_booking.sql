CREATE DATABASE movie_booking_system;
USE movie_booking_system;
CREATE TABLE bookings (
 id INT PRIMARY KEY AUTO_INCREMENT,
 customer_name VARCHAR(100),
 movie_name VARCHAR(100),
 seats VARCHAR(50),
 show_time VARCHAR(100)
);