# LearnUp - learning management system  

## Overview ##

The Learning Management System (LMS) is a web-based application designed to facilitate the educational process by providing an online platform for teachers and students. The application supports two main roles:

* Teacher: Teachers can post assignments, review student submissions, and accept or reject these submissions.

* Student: Students can view and submit assignments for evaluation by their teachers.
  
In addition, the application includes essential functionalities like user registration and login.

## Technologies Used ##

### Backend ###

* Java: Chosen for its robustness, performance, and wide adoption in enterprise-level applications.
  
* Spring Boot: Utilized for its powerful, flexible, and easy-to-use framework for building microservices and web applications. It simplifies the development process with its extensive ecosystem and strong support for RESTful APIs.

* WebSocket: Utilized for real-time notifications, enabling the application to push updates to clients instantly.
  
### Database ###

Relational Database (PostgreSQL): Used for storing notifications information. Relational databases are preferred for their strong ACID compliance, which ensures data integrity and reliability.

## Features ##

* Role Management: Different functionalities and interfaces for teachers and students.

* Real-time Notifications: Using WebSocket to provide instant notifications to users for events like new assignments, submission statuses, and feedback.


## Challenges Faced ##

* WebSocket Integration: Implementing real-time communication between the client and server presented several challenges, including handling multiple concurrent connections and ensuring data consistency.


## How to Run ##
* Clone the repository.
* Open the project in IntelliJ or any other IDE.
* Create a database **lms_notification_service** in postgres.
* Create a .env file in **resources** folder and add configuration like this and update details accordingly  
  
*DB_DATABASE="lms_notification_service"*  
*DB_USER=""*  
*DB_PASSWORD=""*  
  
* Run this microservice and make sure gateway is also up and running.
* Access the application through the provided URL.
  
```
http://localhost:6500
```


### Note ### 
If you face issue in connecting via gateway, try disabling firewall of your antivirus.

