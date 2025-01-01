# Password Manager

## Description
This is a Password Manager application developed using JavaFX for the user interface. Users can securely sign in, and their credentials are encrypted using the Argon2 algorithm. User data is then stored in a MySQL database.

## Features
- User registration and authentication
- Secure password storage with Argon2 encryption
- User data management
- Simple and intuitive user interface

## Installation Steps

1. Clone the Repository:
   ```bash
   git clone https://github.com/Vaibhav2031/password-manager
   cd password-manager

2. Install mysql database
    Use src\main\resources\sql to create tables

3. setup env
    Create following files
        .env.development
        .env.qa
        .env.prod

    Add database details like (.env.* file looks like)
        DB_URL=jdbc:mysql://<hostname>:<port>/<database_name>
        DB_USERNAME=<username>
        DB_PASSWORD=<password>

4. Build Project
    mvn clean install

5. Run Project
    mvn clean javafx:run
