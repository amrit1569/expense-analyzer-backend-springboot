# Expense Analyzer Backend

A secure REST API built with Java Spring Boot for managing personal expenses. The project includes JWT Authentication, Spring Security, PostgreSQL integration, and CRUD operations for expense management.

## Features

- User Registration & Login
- JWT Authentication
- Spring Security
- Expense CRUD APIs
- PostgreSQL Database
- Global Exception Handling
- CORS Configuration
- RESTful API Design

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- JWT
- Hibernate

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.expense.analyzer
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── ExpenseAnalyzerApplication.java
│   └── resources
│       └── application.properties
```

## Setup

### Clone Repository

```bash
git clone https://github.com/amrit1569/expense-analyzer-backend.git
```

### Open Project

Open the project in IntelliJ IDEA.

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Expense analyzer
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run Project

```bash
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8081
```

## Authentication

This project uses JWT Authentication.

Typical flow:

1. Register User
2. Login
3. Receive JWT Token
4. Pass token in Authorization Header

```
Authorization: Bearer YOUR_TOKEN
```

## Main APIs

### Authentication

- POST /auth/register
- POST /auth/login

### Expense

- GET /expenses
- GET /expenses/{id}
- POST /expenses
- PUT /expenses/{id}
- DELETE /expenses/{id}

## Future Improvements

- Expense Categories
- Monthly Analytics
- Charts & Reports
- Email Notifications
- Docker Support
- CI/CD Pipeline
- Unit Testing
- Swagger Documentation

## Author

**Amrit Mishra**

GitHub:
https://github.com/amrit1569