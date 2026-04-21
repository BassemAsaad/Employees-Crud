# Employee Management System

A production-ready **full-stack Spring Boot CRUD application** for managing employee records.
This project demonstrates strong backend engineering fundamentals including **layered architecture, database integration, server-side rendering, and Aspect-Oriented Programming (AOP)**.

Built with clean code principles and clear separation of concerns, the application follows a maintainable **Controller → Service → Repository** architecture.

---

## Overview

This project allows users to perform complete employee management operations through a responsive web interface.
It is designed as a real-world Spring Boot application that showcases:

* Clean layered architecture
* Enterprise-ready CRUD workflows
* Server-side rendered UI with Thymeleaf
* Persistent storage with MySQL
* Cross-cutting logging using AOP

---

## Features

* **Full CRUD Operations**
  Create, view, update, and delete employee records.

* **Responsive UI**
  Built with **Thymeleaf** and **Bootstrap 5** for a clean and user-friendly experience.

* **Database Persistence**
  Uses **Spring Data JPA + Hibernate** for ORM and seamless MySQL integration.

* **Centralized Logging with AOP**
  Logs execution flow across controller, service, and repository layers.

* **Clean Architecture**
  Organized into controller, service, repository, and AOP layers.

---

## Tech Stack

| Layer      | Technology                    |
| ---------- | ----------------------------- |
| Language   | Java 25                       |
| Framework  | Spring Boot 4                 |
| Backend    | Spring Web, Spring Data JPA   |
| ORM        | Hibernate                     |
| AOP        | Spring AOP                    |
| Frontend   | Thymeleaf, HTML5, Bootstrap 5 |
| Database   | MySQL                         |
| Build Tool | Maven                         |

---

## Project Architecture

```text
Controller
   ↓
Service Interface
   ↓
Service Implementation
   ↓
Repository (JPA)
   ↓
MySQL Database
```

This layered approach improves:

* maintainability
* testability
* scalability
* separation of concerns

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

* JDK 25+
* Maven
* MySQL Server

---

## Database Setup

Run the following SQL script:

```sql
CREATE DATABASE IF NOT EXISTS employee_directory;
USE employee_directory;

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    email VARCHAR(45),
    PRIMARY KEY (id)
);

INSERT INTO employee VALUES
(1, 'Leslie', 'Andrews', 'leslie@luv2code.com'),
(2, 'Emma', 'Baumgarten', 'emma@luv2code.com');
```

---

## Configuration

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

## Run the Application

```bash
mvn spring-boot:run
```

The application runs at:

```text
http://localhost:8080
```

---

## API / Web Routes

| Method | Endpoint                      | Description                     |
| ------ | ----------------------------- | ------------------------------- |
| GET    | `/`                           | Redirects to employee dashboard |
| GET    | `/api/employees/list`         | List all employees              |
| GET    | `/api/employees/add`          | Show add employee form          |
| POST   | `/api/employees/add`          | Save new employee               |
| GET    | `/api/employees/edit?id={id}` | Show edit form                  |
| POST   | `/api/employees/edit`         | Update employee                 |
| POST   | `/api/employees/delete`       | Delete employee                 |

---

## Project Structure

```text
src/main/java
├── controller
│   └── EmployeeController.java
├── service
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
├── repository
│   └── EmployeeRepository.java
├── aop
│   └── LoggingAspect.java
└── entity
    └── Employee.java
```

---

## Key Learning Highlights

This project demonstrates practical experience with:

* Spring MVC request handling
* Thymeleaf server-side rendering
* JPA entity mapping
* Hibernate ORM
* layered architecture
* AOP logging
* production-style code organization

---

## Why This Project Matters

This is more than a simple CRUD app.
It reflects **real backend engineering practices** commonly used in enterprise Spring Boot applications.

It is especially useful for showcasing:

* Java backend fundamentals
* clean architecture understanding
* Spring ecosystem knowledge
* job-ready project structure

---

## Future Improvements

Potential enhancements:

* Spring Security authentication & authorization
* REST API version
* Docker containerization
* unit and integration testing
* pagination and search
* audit logging
* role-based access control

---

## Author

**Bassem**
Java Backend Developer | Spring Boot Enthusiast
