## System Diagram

![Fleet Diagram](Er.png)

# Fleet Management and Route Optimization Engine

## Project Overview

Fleet Management and Route Optimization Engine is a Spring Boot based backend application developed to manage fleet operations, drivers, vehicles, and delivery tasks efficiently.

The system helps logistics companies reduce operational costs by managing fleet resources and optimizing delivery workflows.

This application provides REST APIs for:

* Vehicle Registration and Management
* Driver Registration and Assignment
* Delivery Task Management
* Route and Dispatch Management
* Delivery Status Tracking
* Swagger API Documentation
* Docker Container Deployment

---

## Problem Statement

Logistics companies often face challenges such as:

* Inefficient route planning
* Excess fuel consumption
* Poor fleet visibility
* Manual delivery assignment

This project addresses these problems by providing a centralized Fleet Management API with dispatch and route handling capabilities.

---

## Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring WebFlux (if used)

### Database

* MySQL

### API Testing

* Postman

### Documentation

* Swagger / Springdoc OpenAPI

### Containerization

* Docker

---

## Database Schema

Main entities used in the project:

### Driver

Stores driver information:

* Name
* License Number
* License Validity
* Shift Hours

### Vehicle

Stores vehicle information:

* Vehicle Number
* Capacity
* Maintenance Status

### DeliveryTask

Stores delivery task information:

* Pickup Location
* Delivery Location
* Delivery Status
* Assigned Driver
* Assigned Vehicle

### Route

Stores route and dispatch details.

---

## Features

### Fleet Registry

* Register Vehicle
* View Vehicle Details
* Register Driver
* Assign Driver to Vehicle

### Dispatch Workflow

* Create Delivery Task
* Assign Driver and Vehicle
* Dispatch Delivery
* Update Delivery Status

Delivery status flow:

UNASSIGNED → DISPATCHED → IN_TRANSIT → DELIVERED

### Route Management

* Route creation and assignment
* Delivery sequence management
* Fleet monitoring support

---

## API Endpoints

### Vehicle APIs

* POST /api/vehicles
* GET /api/vehicles
* PUT /api/vehicles/{id}
* DELETE /api/vehicles/{id}

### Driver APIs

* POST /api/drivers
* GET /api/drivers
* PUT /api/drivers/{id}
* DELETE /api/drivers/{id}

### DeliveryTask APIs

* POST /api/tasks
* GET /api/tasks
* PUT /api/tasks/{id}
* POST /api/tasks/dispatch/{id}

### Route APIs

* POST /api/routes
* GET /api/routes

---

## Swagger Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html

Swagger provides interactive API testing and documentation.

---

## Docker Setup

Build Docker Image:

docker build -t fms-app .

Run Docker Container:

docker run -p 8080:8080 fms-app

---

## Project Setup

Clone repository:

git clone YOUR_GITHUB_LINK

Open project:

cd fms

Build project:

mvn clean install

Run application:

mvn spring-boot:run

---

## Exception Handling

Global exception handling implemented using:

@RestControllerAdvice

Handles:

* Invalid IDs
* Missing records
* API validation errors
* Internal server errors

---

## Future Enhancements

* Real-time GPS tracking
* Route optimization algorithms
* Fuel usage prediction
* Driver analytics dashboard

---

## Developed By

Komal Kolhe

Internship Project – Fleet Management and Route Optimization Engine
