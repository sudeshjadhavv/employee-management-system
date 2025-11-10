# 👨‍💼 Employee Management System (EMS)

## 📝 Overview
The **Employee Management System** is a backend application built with **Spring Boot** that helps organizations manage employee data efficiently.  
It provides secure **user authentication**, **CRUD operations** for employees, and **role-based access** for different user types (Admin/User).  
All operations are secured using **JWT (JSON Web Token)** authentication.

---

## 🚀 Tech Stack

- **Backend:** Java, Spring Boot  
- **Security:** Spring Security, JWT Authentication  
- **Database:** MySQL  
- **ORM Framework:** Hibernate, JPA  
- **Build Tool:** Maven  
- **API Testing:** Postman  

---

## ⚙️ Features

✅ User registration and login with JWT token-based authentication  
✅ Secure role-based access for Admin and User  
✅ CRUD operations for Employee (Add, Update, View, Delete)  
✅ Relationship mapping between Employee, Department, and Role  
✅ Exception handling and validation  
✅ Passwords are encrypted using BCryptPasswordEncoder  
✅ Stateless authentication using Spring Security  

---

## 🧩 Project Structure
```
com.example.ems
├── 📂 config
│   └── SecurityConfig.java
│
├── 📂 controller
│   ├── AuthController.java
│   └── EmployeeController.java
│
├── 📂 entities
│   ├── User.java
│   ├── Employee.java
│   ├── Department.java
│   └── Role.java
│
├── 📂 repositories
│   ├── UserRepository.java
│   ├── EmployeeRepository.java
│   └── DepartmentRepository.java
│
├── 📂 security
│   ├── JwtAuthenticationFilter.java
│   └── JwtTokenProvider.java
│
├── 📂 services
│   ├── AuthService.java
│   ├── AuthServiceImpl.java
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
│
└── EmployeeManagementSystemApplication.java
```
---

## 🗄️ Database Setup Guide

Follow these steps to configure and connect your MySQL database with the **Employee Management System**:

### 1️⃣ Create the Database
```sql
CREATE DATABASE employee_management;
```
### 2️⃣ Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT Secret (use any random string)
app.jwt-secret=your_jwt_secret_key
app.jwt-expiration=86400000
