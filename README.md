# Payroll Processing & SLA-Safe Escalation System

## Problem Statement
Payroll failures before SLA deadlines cause financial penalties.
This system ensures automatic payroll processing, retry handling,
and SLA-based escalation notifications.

## Tech Stack
- Java
- Spring Boot
- MySQL
- Thymeleaf
- AWS (Deployment)

## Key Features
- Strategy-based payroll salary calculation
- Factory-based processor creation
- Observer-based failure notification system
- SLA escalation scheduler
- Retry mechanism before escalation
- Live payroll dashboard UI

## Architecture
(Add architecture diagram screenshot)

## How to Run
mvn spring-boot:run

Open:
http://localhost:8080/dashboard

## Future Improvements
Kafka event streaming
Distributed retry queue
Microservices deployment
