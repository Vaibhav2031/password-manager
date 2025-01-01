-- Create schema
CREATE SCHEMA password_manager;

-- Use the schema
USE password_manager;

-- Create table with specified fields and constraints
CREATE TABLE users (
    user_name VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    hash_password VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_name)
);

-- Create an index on the user_name field
CREATE INDEX idx_user_name ON users (user_name);
