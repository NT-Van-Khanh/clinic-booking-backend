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

##Running with Docker

This project includes Docker support to quickly set up and run the backend with a MySQL database

### Accessing MySQL Database

When running MySQL inside Docker, you can connect to the database using the following credentials:

- **Port:** 3306 (mapped from the container)
- **Username:** root
- **Password:** 123456
- **Database:** clinic_booking

## Notes
###  The **source code does NOT include the `application.properties` file**

- You need to create and configure `application.properties` manually in your project under `src/main/resources/`.  
- The main configurations you should include in your `application.properties` are:

  - Application settings (e.g.,`server.port`)
  - Database connection (e.g., `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`, `spring.datasource.driverClassName`)
  - JPA/Hibernate settings (e.g., `spring.jpa.show-sql`, `spring.jpa.hibernate.ddl-auto`, `spring.jpa.database-platform`, logging levels)
  - Spring Security (e.g., default user and password for development)
  - Firebase credentials and storage bucket configurations
  - File upload settings (`spring.servlet.multipart.*`)
  - DevTools and debugging options (`spring.devtools.restart.enabled`, `spring.devtools.livereload.enabled`, `debug`)
  - Mail server configurations (`spring.mail.host`, `spring.mail.port`, etc.)
###  The **source code does NOT include the `firebasekey.json' file**

- You need to provide your own `firebasekey.json` file with Firebase service account credentials.
- Place this file in the path configured by `firebase.credentials-path` (e.g., `firebase/firebase-key.json`).
