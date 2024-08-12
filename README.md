# Movie Ticket Booking and Theater/Show Management System

## Overview

This project is a comprehensive Movie Ticket Booking and Theater/Show Management System designed to manage multiple theaters and facilitate ticket bookings for users. The system is built with Spring Boot and includes features for managing movies, theaters, shows, and ticket bookings. It also supports user management and integrates with JWT-based security for authentication and authorization.

## Features

### 1. Movie Management

The system allows administrators to manage the movie catalog by adding new movies, including details like title, language, and release date. This functionality ensures that the movie listings are up-to-date and accurate, providing users with a wide selection of movies to choose from when booking tickets.

### 2. Show Management

The system supports the scheduling of shows for the movies in different theaters. Administrators can create new shows by selecting a movie and a theater, and specifying the showtime. Additionally, the system manages the association of seats with each show, allowing different pricing strategies based on seat types (e.g., regular, VIP).

### 3. Theater Management

Administrators can manage theater information, including adding new theaters and configuring their seating arrangements. The system supports the creation of seating layouts, enabling theaters to define different types of seats (e.g., regular, VIP) and their corresponding arrangements. This feature ensures that theaters can offer a structured and organized booking experience for users.

### 4. Ticket Booking

The system facilitates ticket booking for users, allowing them to select a show, choose their seats, and book tickets. The booking process checks for seat availability in real-time and calculates the total cost based on the selected seats. Once booked, the seats are marked as unavailable to prevent double booking, and the user receives a booking confirmation.

### 5. User Management

The system includes basic user management functionality, allowing for the registration of new users. Each user can book tickets for shows, and their booking history is maintained within the system. This functionality ensures that users have personalized access to the system and can manage their bookings efficiently.

### 6. Security

Security is handled using JWT-based authentication, ensuring that only authorized users can perform certain actions within the system. This includes access control over the management features for movies, shows, and theaters, which are typically restricted to administrators.

## Getting Started

To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Pebble32/Movie-Booking-System.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd movie-booking-system
   ```
3. **Build the project**:
   ```bash
   ./mvn clean install
   ```
4. **Run the application**:
   ```bash
   ./mvn spring-boot:run
   ```
## API Documentation
Detailed API documentation will be available via Swagger once the application is running. Visit `http://localhost:8080/swagger-ui.html` to explore the endpoints and their usage.
