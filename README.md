# Product-management-system

## Overview

The Product Management System is a web application built using Spring Boot, Spring Data JPA, and MongoDB. It provides functionalities for managing products and categories, supporting CRUD operations and advanced querying.

## Features

- **Product Management:**
  - Add, update, delete, and retrieve products.
  - Associate products with categories.
  - Pagination and sorting of product listings.

- **Category Management:**
  - Create, update, delete, and retrieve categories.
  - Products categorized under specific categories.

- **Database Integration:**
  - PostgreSQL for relational data storage (configured via JPA).
  - MongoDB for NoSQL data storage (used for binary tree implementation).

- **Additional Features:**
  - Binary tree implementation for efficient product categorization and retrieval.
  - Interceptors for logging and authentication purposes.

## Technologies Used

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- Spring Data MongoDB
- PostgreSQL
- MongoDB
- Maven
