
# TODO List Rest APIs
This is a simple TODO list application with user authentication. It allows users to register, login, and manage their TODO items. Each TODO item has a unique identifier, a title, a description, and a status (e.g., completed or pending). Users can only access and modify their own TODO items. The application stores user information and TODO items in a database.
## Installation

 1. Clone this repository to your local machine:
 
 2. Navigate to the project directory:
 
 3. Open Project in preferredIde
 
 4. Setup JRE 
 
 5. Run Project along with mysql server 
 (change database name , username and password in application.properties before running)

 
    
## Tech Stack

**Programming Language:** Java

**FrameWork:** Spring Boot

**Database:** MySQL

**Server:** Embedded TOMCAT


## Requirements
Java 17 or Above
## Authors

- [@pratyendu](https://www.github.com/pratyendu)


## Endpoints Provided

 Use following swagger url to test the API endpoints:

  Swagger Url = http://localhost:8080/swagger-ui/index.html#/
  
  EndPoints Provided : 
  
  /register-user
  
  /login
  
  /create-todo
  
  /get-todos
  
  /update-todo
  
  /delete-todo
