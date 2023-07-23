# Hotel Service Backend Microservices Project
This repository contains a comprehensive microservice-based backend solution for a hotel service application, developed using Spring Boot. The project consists of three microservices - UserService, HotelService, and RatingService, along with essential components like API Gateway, Config Server, Discovery Client, Service Registry, Feign Client, Resilience4j Circuit Breaker, Retry Mechanism, Rate Limiter, and Spring Security with Okta. All endpoints have been thoroughly tested using Postman for reliability and functionality.

# Microservices
- UserService: The UserService microservice handles user-related operations, including user registration and user profile management.
- HotelService: The HotelService microservice is responsible for managing hotel-related functionalities.
- RatingService: The RatingService microservice enables users to submit and retrieve hotel ratings and reviews.

# Components : 
The project incorporates the following components to enhance its functionality:

- API Gateway: The API Gateway acts as a single entry point for all client requests and efficiently routes them to the respective microservices.
- Config Server (GitHub): The Config Server centralizes the configuration management for all the microservices and retrieves configurations from a GitHub repository, making it easier to manage and modify configurations.
- Discovery Client: The Discovery Client allows microservices to discover and communicate with each other without hardcoding service locations.
- Service Registry (Spring Eureka): The Service Registry, powered by Spring Eureka, allows microservices to register themselves and enables service discovery.
- Feign Client (Spring Cloud Routing): The Feign Client provides a declarative way to make API calls to other microservices, simplifying inter-service communication.
- Netflix Eureka Client (Spring Cloud): The Netflix Eureka Client is used to register microservices with the Eureka Service Registry for service discovery.
- Resilience4j Circuit Breaker: The Resilience4j Circuit Breaker pattern helps in preventing cascading failures by providing fault tolerance when calling remote services.
- Retry Mechanism: The Retry mechanism is employed to automatically retry failed requests, improving the overall reliability of the system.
- Rate Limiter: The Rate Limiter controls the rate of incoming requests to prevent overloading the microservices.
- Spring Security with Okta: Spring Security is integrated with Okta to handle authentication and authorization, ensuring secure access to the microservices.


