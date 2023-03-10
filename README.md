Documentation for Spring Boot Application
Overview:
This is a Spring Boot application that manages employees and their assigned tasks. The application is built using Spring Boot version 3.0.4 and Java version 19, and uses Maven for build automation. The application also uses Flyway migration for database schema management, Spring Data JPA for database access, and Spring Web for creating REST APIs. The application is designed to work with a PostgreSQL database.

Entities:
The application has two entities: Employee and Task.

Employee entity has the following attributes:

fullName: String - Full name of the employee.
email: String - Email address of the employee.
phoneNumber: String - Phone number of the employee.
dateOfBirth: LocalDate - Date of birth of the employee.
monthlySalary: BigDecimal - Monthly salary of the employee.
Task entity has the following attributes:
title: String - Title of the task.
description: String - Description of the task.
employee: Employee - Employee assigned to the task.
dueDate: LocalDate - Due date of the task.
REST APIs:
The application has REST APIs to perform CRUD operations on both Employee and Task entities.

Employee REST APIs:
POST /employee/save - This API creates a new employee. It accepts a JSON payload with the employee details and returns the created employee in the response body.
DELETE /employee/delete/{id} - This API deletes an existing employee with the given ID.
PUT /employee/update/{id} - This API updates an existing employee with the given ID. It accepts a JSON payload with the updated employee details and returns the updated employee in the response body.
GET /employee/all - This API retrieves all the employees in the database. It supports pagination and returns a CustomPageDto object with the list of employees.

Task REST APIs:
POST /task/save - This API creates a new task. It accepts a JSON payload with the task details and the ID of the employee assigned to the task, and returns the created task in the response body.
DELETE /task/delete/{taskId} - This API deletes an existing task with the given ID.
PUT /task/update/{taskId} - This API updates an existing task with the given ID. It accepts a JSON payload with the updated task details and the ID of the employee assigned to the task, and returns the updated task in the response body.
GET /task/all - This API retrieves all the tasks in the database. It supports pagination and returns a CustomPageDto object with the list of tasks.
Additional API:

GET /employee/top-5-employees - This API retrieves the top 5 employees who completed the most tasks in the past month. It returns a list of Employee objects.
Dependencies:
The application uses the following dependencies:

Flyway migration: This dependency is used for database schema management.
Spring Data JPA: This dependency is used for database access.
Spring Web: This dependency is used for creating REST APIs.
PostgreSQL Driver: This dependency is used for connecting to the PostgreSQL database.
Build and Deployment:
To build and run the application, follow these steps:

Clone the project from the repository.
Configure the PostgreSQL database credentials in the application.properties file.
Build the project using Maven. 
Start the application. Run the following command in the project root directory:
Conclusion:
This Spring Boot application provides APIs to manage employees and their assigned tasks. It uses Flyway migration for database schema management, Spring Data JPA for database access, and Spring Web for creating REST APIs.
