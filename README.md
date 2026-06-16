# Spring Boot JWT Authentication System

A secure REST API authentication backend built with Spring Boot.

## Features
- User registration with BCrypt password hashing
- Email verification via 6-digit OTP (SMTP/Gmail)
- JWT-based stateless authentication
- Protected endpoints with Spring Security filter chain
- PostgreSQL database with JPA/Hibernate

## Tech Stack
- Java 21, Spring Boot 3.4
- Spring Security, JJWT
- PostgreSQL, Spring Data JPA
- Jakarta Mail (SMTP)

## API Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/auth/signup` | No | Register new user |
| POST | `/auth/verify` | No | Verify email with OTP |
| POST | `/auth/login` | No | Login, returns JWT token |
| POST | `/auth/resend` | No | Resend verification code |
| GET | `/users/me` | Yes | Get current user profile |
| GET | `/users/` | Yes | Get all users |

## Setup

1. Clone the repo
2. Create a `.env` file with:
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/yourdb

SPRING_DATASOURCE_USERNAME=youruser

SPRING_DATASOURCE_PASSWORD=yourpassword

JWT_SECRET_KEY=your-base64-secret

SUPPORT_EMAIL=your@gmail.com

APP_PASSWORD=your-gmail-app-password

3. Run: `./gradlew bootRun`

## Auth Flow
1. Register → account created, verification email sent
2. Verify OTP → account activated
3. Login → receive JWT token (1 hour expiry)
4. Use token in `Authorization: Bearer <token>` header for protected routes
