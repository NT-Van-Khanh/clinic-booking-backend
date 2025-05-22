# Clinic Booking Backend
This is the backend system for a Clinic Booking application, built with Java, Spring Boot, and MySQL. 

It provides RESTful APIs for user registration, login, appointment scheduling, patient/doctor management, and image uploads to Firebase Storage. Security is ensured using JWT-based authentication with Spring Security.

## Technologies Used

- Java 17+
- Spring Boot
- Spring Security (JWT)
- MySQL
- Firebase Storage (for image upload)
- JPA (Hibernate)
- Maven

## Authentication & Roles

This project uses **Spring Security with JWT** for authentication. Role-based access control is applied based on request paths:

| Endpoint Pattern              | Access Role         |
|------------------------------|---------------------|
| `/api/v1/auth/**`            | Public (Register/Login) |
| `/api/v1/m/**`               | Manager only        |
| `/api/v1/d/**`               | Doctor only         |
| `/api/v1/sh/**`              | Manager, Doctor     |
| `/api/v1/p/**`               | Public (Patient actions) |

JWT Flow
Login to receive a JWT token.

Use Authorization: Bearer <token> header in subsequent requests.

## Sample Accounts

For testing purposes, the following user accounts are available:

| Role     | Username  | Password  |
|----------|-----------|-----------|
| Manager  | manager1  | 12345678  |
| Doctor   | doctor1   | 12345678  |
