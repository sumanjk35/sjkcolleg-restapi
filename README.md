# SJK College REST API

## Overview
This project is a Spring Boot REST API for enrolling engineering college students. It provides CRUD operations to manage student details such as Roll Number, First Name, Last Name, Email ID, Address, and Department. The application connects to an Azure SQL database and is designed to be deployed as a WAR file in Azure Web App Service.

## Project Structure
```
sjkcollege-restapi
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── sjkcollege
│   │   │           ├── SjkcollegeApplication.java
│   │   │           ├── controller
│   │   │           │   └── StudentController.java
│   │   │           ├── service
│   │   │           │   └── StudentService.java
│   │   │           ├── repository
│   │   │           │   └── StudentRepository.java
│   │   │           ├── model
│   │   │           │   └── Student.java
│   │   │           ├── exception
│   │   │           │   ├── CustomException.java
│   │   │           │   └── ExceptionHandlerAdvice.java
│   │   │           └── config
│   │   │               └── AzureSQLConfig.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── messages.properties
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── sjkcollege
│   │               └── StudentServiceTests.java
├── pom.xml
├── README.md
```

## Database Setup
### Create Table
```sql
CREATE TABLE Student (
    roll_number VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    department VARCHAR(50) NOT NULL
);
```

### Sample Data Insertion
```sql
INSERT INTO Student (roll_number, first_name, last_name, email, address, department) VALUES
('4JK25CV001', 'John', 'Doe', 'john.doe@example.com', '123 Main St', 'Computer Science'),
('4JK25CV002', 'Jane', 'Smith', 'jane.smith@example.com', '456 Elm St', 'Electrical Engineering');
```

## Dependencies
- Spring Boot Starter Data JPA
- Microsoft SQL Server JDBC Driver
- Spring Boot Starter Logging

## Packaging
Ensure the `pom.xml` is configured to create a WAR file:
```xml
<packaging>war</packaging>
```
## Setup Instructions

1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   cd sjkcollege-rest-api
   ```

2. **Configure Database Connection**: 
   Update the `src/main/resources/application.properties` file with your Azure SQL database connection details.

3. **Build the Project**: 
   Use Maven to build the project and create a WAR file:
   ```
   mvn clean package
   ```

4. **Deploy to Azure**: 
   Deploy the generated WAR file to Azure Web App Service with Windows OS option.

## Deployment
This project is designed to be deployed in Azure Web App Service with Windows OS. Follow Azure documentation for deployment steps.

## Exception Handling
General user exceptions are managed in the `ExceptionHandlerAdvice` class. Custom messages for exceptions and validations are defined in the `messages.properties` file.

## Logging
Logging is implemented using SLF4J or Log4j2 to track service transactions and handle success and failure scenarios.

## API Endpoints
The base URL for the API is `/sjkcollege/`. The following endpoints are available for CRUD operations:
- **POST** `/sjkcollege/students` - Create a new student
- **GET** `/sjkcollege/students/{rollNumber}` - Retrieve a student by roll number
- **PUT** `/sjkcollege/students/{rollNumber}` - Update an existing student
- **DELETE** `/sjkcollege/students/{rollNumber}` - Delete a student by roll number



## Conclusion
This README provides an overview of the SJK College REST API project, including its structure, database setup, dependencies, and API endpoints. For further details, refer to the individual class files and configurations within the project.# sjkcollege-restapi
