CREATE TABLE IF NOT EXISTS dishes (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price DECIMAL(8, 2) NOT NULL
);