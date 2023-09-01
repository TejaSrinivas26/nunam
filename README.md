Creating a full-fledged Spring Boot project with all the required code, database schema, and documentation is beyond the scope of a single response. However, I can provide you with a step-by-step guide on how to approach this project, along with sample code snippets and a README template.

Step 1: Database Design
First, you need to design the database schema. Based on your requirements, here's a simplified representation:

Database Schema (Sample):
Users Table
id (Primary Key)
username
password
EmailNotifications Table
id (Primary Key)
email
message
timestamp
Create these tables in your database.

Step 2: Spring Boot Project Setup
Create a new Spring Boot project using your preferred IDE or Spring Initializr (https://start.spring.io/).

Set up your project's dependencies: Spring Web, Spring Security, Spring Data JPA, and any other dependencies you may need.

Create a User entity class and a EmailNotification entity class to map to your database tables. Use annotations like @Entity, @Table, and @Id to define the entity structure.

Set up your application.properties or application.yml to configure the database connection.

Step 3: Implement Authentication
Create a controller for authentication. This controller should handle the /api/auth endpoint.

Implement a service that checks the provided username and password against the database. If they match, generate a JWT token and return it as a response. If not, return a 401 Unauthorized response.

Use Spring Security to configure authentication for this endpoint. You can use UsernamePasswordAuthenticationFilter to handle authentication.

Step 4: Implement Notification
Create a controller for notifications. This controller should handle the /api/notify endpoint.

Implement a service that checks the JWT token provided in the request header. If it's valid, check if the user has sent more than one notification to the same email within 5 minutes by querying the EmailNotifications table.

If the token is valid and the user hasn't sent too many notifications, send the email and log it in the EmailNotifications table.

Step 5: Documentation and README
Create a README.md file in your project repository. Here's a sample template:
# Alert Management System

This project is an Alert Management System with two REST endpoints implemented using Spring Boot.

## Prerequisites

- Java 8+
- Maven
- MySQL Database
- SMTP Server for Sending Emails

## Frameworks Used

- Spring Boot
- Spring Security
- Spring Data JPA
- JSON Web Tokens (JWT)
- ...

## Installation

1. Clone this repository.
2. Configure your MySQL database in `application.properties`.
3. Build the project using Maven: `mvn clean install`.
4. Run the Spring Boot application: `mvn spring-boot:run`.

## Endpoints

### Authentication Endpoint

**Endpoint**: `/api/auth`
**Method**: POST
**Sample Request Body**:

```json
{
  "username": "admin",
  "password": "1234"
}
Notification Endpoint
Endpoint: /api/notify
Method: POST
Headers:
{
  "Authorization": "Bearer <access-token>"
}
Sample Request Body:
{
  "email": "sample@nunam.com",
  "message": "alert"
}
## Database Schema
Users Table
id (Primary Key)
username
password
EmailNotifications Table
id (Primary Key)
email
message
timestamp

Replace the placeholders with actual information in the README template.

### Step 6: Testing and Deployment

Test your endpoints thoroughly, and once you're satisfied with the functionality, deploy your Spring Boot application to a server of your choice.

Remember to push your code to a GitHub repository and provide the repository URL as part of your submission.

This is a high-level overview of how to approach your project. You'll need to write actual code for controllers, services, and other components, and configure Spring Security and JWT token handling. Additionally, you can add further enhancements and features based on your requirements and creativity.
