-- Create Database
DROP DATABASE IF EXISTS 311project;
CREATE DATABASE 311project;

-- Create Java User
DROP USER 'java'@'localhost';
CREATE USER 'java'@'localhost' IDENTIFIED BY '311projectpassword';
GRANT ALL PRIVILEGES ON *.* TO 'java'@'localhost' IDENTIFIED BY '311projectpassword' WITH GRANT OPTION;
