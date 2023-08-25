# Spring Boot User Authentication and Authorization Project

This is a sample Spring Boot project that demonstrates user authentication and authorization using Spring Security. It includes a basic setup for securing API endpoints and registering users.

## Table of Contents
- [Project Overview](#project-overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Authentication and Authorization](#authentication-and-authorization)
- [Testing with Postman](#testing-with-postman)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

This Spring Boot project provides a simple user authentication and authorization system. It uses Spring Security to secure API endpoints and includes user registration. Users' information is stored in a database.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (Java 8 or later)
- Maven installed
- Your favorite Integrated Development Environment (IDE)

### Running the Application

1. Clone this repository:

   ```shell
   git clone url
   ```

2. Open the project in your IDE.

3. Configure the database settings in `application.properties` :

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/user_demo
   spring.datasource.username=root
   spring.datasource.password=12345
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.properties.hibernate.show_sql=true
   ```

4. Build and run the application using Maven:

   ```shell
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## API Endpoints

### User Registration

- `POST /user/register` - Register a new user.

### User Management (requires admin role)

- `GET /api/users/{userId}` - Get user details by ID.
- `DELETE /api/users/{userId}` - Delete user by ID.

## Authentication and Authorization

- The application uses Spring Security for authentication and authorization.
- User passwords are hashed using BCrypt before storing them in the database.
- User roles are defined as `USER` and `ADMIN`.
- Only authenticated users can access most API endpoints.
- Admins have access to user management endpoints.

## Testing with Postman

You can use Postman to test the API endpoints. Import the provided Postman collection and environment to get started.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/your-collection-id)

To set up Postman for testing:

1. Install Postman if you haven't already: [Postman Download](https://www.postman.com/downloads/).

2. Import the provided Postman collection (`Spring_Security_Demo.postman_collection.json`) and environment (`Spring_Security_Demo.postman_environment.json`) into Postman.

3. Configure the environment variables for your local setup.

4. Start testing the API endpoints.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make your changes and commit them.

4. Push your changes to your fork.

5. Create a pull request to the `main` branch of this repository.

6. Please provide a detailed description of your changes in the pull request.



---

Thank you for using and contributing to this Spring Boot project! If you have any questions or need further assistance, feel free to contact us.
