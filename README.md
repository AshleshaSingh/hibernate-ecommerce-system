# Hibernate E-Commerce Management System

## Project Overview

This project is a Hibernate-based Java application that manages an e-commerce system.  
It demonstrates entity relationships, CRUD operations, order management, and advanced Hibernate features such as join fetch optimization, named queries, soft delete, and pagination.

The system models a realistic e-commerce workflow including categories, products, users, orders, and order details.

---

## Technologies Used

- Java
- Hibernate ORM
- MySQL
- Maven
- JPA Annotations

---

## System Design

### Entities Implemented

- **Category**
  - One-to-Many → Product

- **Product**
  - Many-to-One → Category
  - Many-to-One → OrderDetails
  - Soft delete supported (`deleted` flag)

- **Users**
  - One-to-Many → Orders

- **Orders**
  - Many-to-One → Users
  - One-to-Many → OrderDetails

- **OrderDetails**
  - Many-to-One → Orders
  - Many-to-One → Product

---

## Core Features Implemented

- Hibernate configuration using `hibernate.cfg.xml`
- Programmatic entity registration in `HibernateUtil`
- Proper cascading strategies
- LAZY fetching configuration
- CRUD operations:
  - Insert Category
  - Insert Product
  - Insert User
  - Create Order with multiple OrderDetails
  - Fetch Orders with associated Users and Products

---

## Performance Optimization

- Implemented `JOIN FETCH` to avoid the N+1 query problem
- Optimized read operations for Orders

---

## Bonus Features

- NamedQuery for fetching active products by category
- Soft delete implementation using `deleted` flag
- Pagination using:
  - `setFirstResult()`
  - `setMaxResults()`

---

## Database Setup

### 1️Create MySQL Database

```sql
CREATE DATABASE ecommerce_db;
```

### 2️Update Database Credentials

Open `hibernate.cfg.xml` and replace:

```
YOUR_DB_USERNAME
YOUR_DB_PASSWORD
```

with your local MySQL credentials.

---

## How To Run

1. Clone the repository
2. Import as a Maven project
3. Update MySQL credentials in `hibernate.cfg.xml`
4. Run `App.java`

Uncomment specific operations inside `App.java` to test:
- Seeding data
- CRUD operations
- Pagination
- Soft delete
- Named queries

---

## Project Structure

```
src/main/java/com/ecommerce/platform
│
├── entity        → JPA entity classes
├── crud          → CRUD operation classes
├── util          → HibernateUtil (SessionFactory management)
└── App.java      → Application entry point
```

---

## Database Schema

The database structure is included in:

```
schema.sql
```

---

## Security Note

Database credentials are not stored in the repository.  
Replace placeholder values in `hibernate.cfg.xml` before running.

---

## ‍Author

Ashlesha Singh