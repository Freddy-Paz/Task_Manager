# Task Manager API

Simple REST API developed with Spring Boot for task management.

## Features

- Create tasks
- List all tasks
- Get task by ID
- Update tasks
- Delete tasks

## Technologies

- Java
- Spring Boot
- Maven
- MySQL
- Flyway
- Lombok

## Endpoints

| Method | Endpoint      | Description        |
|--------|---------------|--------------------|
| GET    | /task         | Get all tasks      |
| GET    | /task/{id}    | Get task by ID     |
| POST   | /task         | Create a new task  |
| PUT    | /task/{id}    | Update a task      |
| DELETE | /task/{id}    | Delete a task      |

## Run the project

```bash
mvn spring-boot:run
```

## Notes

This project was created for practice purposes and learning Spring Boot REST APIs.
