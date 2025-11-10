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
