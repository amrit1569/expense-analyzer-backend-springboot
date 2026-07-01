# Expense Analyzer Backend

A Spring Boot REST API for Expense Analyzer.

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- JWT Authentication
- PostgreSQL
- Maven

## Features

- User Registration
- User Login
- JWT Authentication
- Password Encryption (BCrypt)
- Role Based Authorization
- REST APIs

## Run Locally

```bash
git clone https://github.com/amrit1569/expense-analyzer-backend.git
cd expense-analyzer-backend/analyzer
```

Run the application:

```bash
./mvnw spring-boot:run
```

or on Windows:

```bash
mvnw.cmd spring-boot:run
```

Backend runs on:

```
http://localhost:8081
```

## API Endpoints

### Register

```
POST /auth/register
```

### Login

```
POST /auth/login
```

## Author

Amrit Mishra
