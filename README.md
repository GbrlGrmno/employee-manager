# Employee Management System

## Summary
This is a RESTful API built with Spring Boot that manages employee data. It provides endpoints for creating, reading, updating, and deleting employee records, along with handling common exceptions. 

## Table of Contents
- [Summary](#summary)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installing](#installing)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)

## Features
- Create, read, update, and delete employee records.
- Exception handling for common scenarios (e.g., `EmployeeNotFoundException`, `EmailAlreadyExistsException`).
- Full documentation with **OpenAPI** for easy API exploration.
- Swagger UI for interactive API testing.

## Prerequisites
Ensure that your system has the following installed:
- **Java 23** or higher
- **Maven** (version 3.6 or higher)
- **MySQL** 8 or higher
- **Git** for version control

## Installing
1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/https://github.com/GbrlGrmno/employee-manager.git
   ```
2. Configure the application.properites file:
    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_manager
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    ```
3. Build the project:
    ```bash
    mvn clean install
    ```
4. Run the project:
    ```bash
    mvn spring-boot:run
    ```
## Usage
Once the application is running, you can access the API through your local server. The following steps outline how to interact with the application:

### Accessing the API
- **Base URL**: `http://localhost:8080`

### Example Endpoints
- `GET /employee`: Retrieve all employees currently stored in the application.
- `GET /employee/{id}`: Fetch details of a specific employee by providing their unique ID.
- `POST /employee`: Create a new employee. The request body should include the employee's details in JSON format.
- `PUT /employee/{id}`: Update the details of an existing employee using their ID.
- `DELETE /employee/{id}`: Remove an employee record by ID.

### Example Request for Creating an Employee
```
POST /employee
Content-Type: application/json

{
  "name": "Gabriel",
  "email": "gabriel@example.com",
  "position": "Software Engineer"
  "salary": 10000.00
}
```
### Example Response for Successfull Creation

```http
{
    "id": 1
    "name": "Gabriel",
    "email": "gabriel@example.com",
    "position": "Software Engineer"
    "salary": 10000.00
}
```

## API Documentation
This project is integrated with **SpringDoc OpenAPI**, providing interactive and comprehensive API documentation.

### Accessing Swagger UI
To interact with the API and explore the available endpoints, open your browser and navigate to:
- **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### API Operations Overview
Each endpoint is documented with details such as:
- **Summary**: A brief overview of the endpoint's purpose.
- **Description**: Detailed information on what the endpoint does.
- **HTTP Method**: The type of request (e.g., `GET`, `POST`, `PUT`, `DELETE`).
- **Request Body**: The expected format and example of the request payload.
- **Response Codes**: Documented possible responses including status codes, descriptions, and response content.

### Example of Documented API Operation
```java
@GetMapping("/{id}")
@Operation(summary = "Get an Employee by ID", description = "Retrieves the details of an employee based on the provided ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Employee found and returned"),
    @ApiResponse(responseCode = "404", description = "Employee not found")
})
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
    // Method implementation
}
```

### Contributing

If you'd like to contribute to this project and help improve it with new ideas, we warmly welcome your pull requests. If you encounter any issues, please feel free to report them in the repository's issue section. Thank you!