# Employee Management System (REST API)

A production-ready Spring Boot backend application for managing employee records. This project demonstrates core backend development principles, including a robust RESTful architecture, Data Transfer Object (DTO) patterns, centralized exception handling, database integration, and Aspect-Oriented Programming (AOP). It is structured with clean code practices, utilizing distinct Service, Repository, and Controller layers to ensure maintainability and scalability.

## 🚀 Features
* **RESTful API Architecture:** Exposes standard endpoints utilizing appropriate HTTP methods (GET, POST, PUT, DELETE) and standardized `ResponseEntity` status codes (e.g., `201 CREATED`, `204 NO CONTENT`).
* **Data Transfer Objects (DTO):** Utilizes Java Records (`AddEmployeeRequest`, `UpdateEmployeeRequest`, `EmployeeResponse`) to decouple the database entities from the API layer, improving security and preventing over-posting.
* **Global Exception Handling:** Employs `@ControllerAdvice` to intercept exceptions (like `EmployeeNotFoundException`) globally and return standardized JSON error responses containing timestamps, status codes, and error messages.
* **Database Integration:** Fully integrated with MySQL using Spring Data JPA and Hibernate for robust object-relational mapping.
* **Aspect-Oriented Programming (AOP):** Implements centralized, cross-cutting logging across the Controller, Service, and Repository packages using `@Before` and `@AfterReturning` pointcuts to trace application execution flow seamlessly.
* **Clean Architecture:** Separation of concerns using Controller, Service (interface and implementation), and Repository layers.

## 🛠️ Tech Stack
* **Java:** 25
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring AOP)
* **Database:** MySQL (JDBC Connector)
* **Data Mapping:** Java Records for DTOs

## 📋 Prerequisites
Before running the project, ensure you have the following installed:
* Java Development Kit (JDK) 25 or higher
* Maven
* MySQL Server (running on default port `3306`)

## ⚙️ Getting Started

### 1. Database Initialization
Create the necessary database and table using the provided SQL script. You can execute this in your MySQL Workbench or command line:

```sql
CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Optional: Insert sample data
INSERT INTO `employee` VALUES 
    (1,'Leslie','Andrews','leslie@luv2code.com'),
    (2,'Emma','Baumgarten','emma@luv2code.com');