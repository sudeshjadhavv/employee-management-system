# 👨‍💼 Employee Management System (EMS)

## 📝 Overview
The **Employee Management System** is a backend application built with **Spring Boot** that helps organizations manage employee data efficiently.  
It provides secure **user authentication**, **CRUD operations** for employees, and **role-based access** for different user types (Admin/User).  
All operations are secured using **JWT (JSON Web Token)** authentication.

---

## 🧰 Tech Stack

| Layer | Technology |
|:------|:------------|
| *Language* | Java 17 |
| *Framework* | Spring Boot |
| *ORM* | Hibernate / JPA |
| *Database* | MySQL |
| *Security* | Spring Security with JWT |
| *Build Tool* | Maven |
| *API Testing* | Postman  |
| *Version Control* | Git & GitHub |

---
## 🌟 Key Features

✅ **User Authentication & Authorization** — Secure login and registration using JWT-based authentication with roles like `ADMIN` and `USER`.

✅ **Role-Based Access Control** —  
- `ADMIN` → Manage employees, departments, and roles  
- `USER` → View personal profile and basic employee details  

✅ **Employee Management** — Add, update, delete, and view employee details such as name, designation, salary, and department.

✅ **Department Management** — Create and manage different departments and assign employees accordingly.

✅ **Role Management** — Define and manage various job roles within the organization.

✅ **Database Integration** — Persistent and relational data management using Hibernate and MySQL.

✅ **RESTful APIs** — Clean, modular APIs for handling employee, department, and role operations.

✅ **Input Validation & Exception Handling** — Robust validation and centralized exception handling for better API reliability.

✅ **JWT Secured Endpoints** — All sensitive operations are protected using token-based security.

✅ **Scalable Architecture** — Built using Spring Boot and layered architecture (Controller → Service → Repository).

---

## 🧩 Project Structure
```
employee-management-system/
│
├── 📦 src/
│ └── 📁 main/
│ ├── 📁 java/
│ │ └── 📁 com/
│ │ └── 📁 example/
│ │ └── 📁 ems/
│ │ ├── 📁 config/ # Security and application configurations
│ │ │ └── SecurityConfig.java
│ │ │
│ │ ├── 📁 controller/ # Handles REST API endpoints
│ │ │ ├── AuthController.java
│ │ │ └── EmployeeController.java
│ │ │
│ │ ├── 📁 entities/ # JPA entities and relationships
│ │ │ ├── User.java
│ │ │ ├── Employee.java
│ │ │ ├── Department.java
│ │ │ └── Role.java
│ │ │
│ │ ├── 📁 repositories/ # Spring Data JPA repositories
│ │ │ ├── UserRepository.java
│ │ │ ├── EmployeeRepository.java
│ │ │ └── DepartmentRepository.java
│ │ │
│ │ ├── 📁 security/ # JWT authentication and token management
│ │ │ ├── JwtAuthenticationFilter.java
│ │ │ └── JwtTokenProvider.java
│ │ │
│ │ ├── 📁 services/ # Business logic and service layer
│ │ │ ├── AuthService.java
│ │ │ ├── AuthServiceImpl.java
│ │ │ ├── EmployeeService.java
│ │ │ └── EmployeeServiceImpl.java
│ │ │
│ │ └── EmployeeManagementSystemApplication.java # Main Spring Boot class
│ │
│ └── 📁 resources/
│ └── application.properties # Database and Hibernate configuration
│
├── 📄 pom.xml # Maven dependencies and build configuration
└── 📄 README.md # Project documentation
```
---

## 🧭 System Architecture

The **Employee Management System** follows a layered architecture with the following components:

- **Controller Layer** → Handles incoming HTTP requests and responses.  
- **Service Layer** → Contains business logic and communicates with repositories.  
- **Repository Layer** → Manages database operations using Spring Data JPA.  
- **Security Layer** → Handles JWT-based authentication and authorization.  
- **Entity Layer** → Defines database models (Employee, Department, Role, User).  

This architecture ensures **scalability, maintainability, and clear separation of concerns.**

---

## ⚙️ Setup & Installation

### 🪜 Prerequisites

Before running this project, ensure you have installed:

- **Java 17+**  
- **Maven 3.9+**  
- **MySQL 8+**  
- **Postman** *(optional, for API testing)*
### 🧩 Steps to Run Locally

1. *Clone the repository*
   ```
   git clone https://github.com/sudeshjadhavv/employee-management-system.git
   cd employee-management-system
### 🗄️ Database Setup Guide

Follow these steps to configure and connect your MySQL database with the Vehicle Service Management System:

### 1️⃣ Create the Database
sql
CREATE DATABASE employee_management;
### 2️⃣ Configure application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
# JWT Secret (use any random string)
```
app.jwt-secret=your_jwt_secret_key
app.jwt-expiration=86400000
```

### 3️⃣ Run the Application

bash
mvn spring-boot:run

### 4️⃣ Verify Database Tables

Once the application starts successfully, open **MySQL Workbench** and verify that these tables are created:

```
SHOW TABLES;
+-----------------------+
| Tables_in_employee_management |
+-----------------------+
| users                 |
| employees             |
| departments           |
| roles                 |
+-----------------------+
```
---

## 🧩 Database Design

The **Employee Management System** database follows a relational schema with proper entity relationships and normalization.

### 🗂️ Entity-Relationship Overview

```text
+------------------+        +------------------+        +------------------+
|      users       |        |   departments    |        |      roles       |
+------------------+        +------------------+        +------------------+
| id (PK)          |        | id (PK)          |        | id (PK)          |
| username         |        | name             |        | name             |
| password         |        +------------------+        +------------------+
| role             |
+------------------+

          ▲
          │
          │
+------------------+
|    employees     |
+------------------+
| id (PK)          |
| name             |
| email            |
| salary           |
| department_id (FK) --> departments.id
| role_id (FK)       --> roles.id
+------------------+
```
### 5️⃣ Insert Sample Data (Admin, Department, Role)
```
After the database and tables are ready, insert sample users and roles to test the system.
-- INSERT SAMPLE ADMIN USER
INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$ABC12345HashedPasswordHere', 'ADMIN');

-- INSERT SAMPLE DEPARTMENTS
INSERT INTO departments (name) VALUES
('Human Resources'),
('IT Department'),
('Finance');

-- INSERT SAMPLE ROLES
INSERT INTO roles (name) VALUES
('Manager'),
('Developer'),
('HR Executive');

-- INSERT SAMPLE EMPLOYEES
INSERT INTO employees (name, email, salary, department_id, role_id) VALUES
('John Doe', 'john.doe@example.com', 55000, 2, 2),
('Priya Sharma', 'priya.sharma@example.com', 60000, 1, 1),
('Ravi Kumar', 'ravi.kumar@example.com', 50000, 3, 3);
```
## 6️⃣ 🚀 API Endpoints Documentation

Below are the main RESTful API endpoints for the *Employee Management System*.  
Use *Postman* to test each API.

---

## 🔐 Authentication Workflow

1. **Register User** → `/api/auth/register`  
   User details (username, password) are saved in the database (passwords are encrypted).  

2. **Login User** → `/api/auth/login`  
   Returns a **JWT token** upon successful login.

3. **Use JWT Token in Postman:**  
   - Copy the token from the login response.  
   - Go to the **Authorization** tab in Postman.  
   - Choose **Bearer Token** and paste your token.  
   - Now you can access all secured endpoints.

---

## 📡 API Endpoints

### 🔑 Authentication
| Method | Endpoint | Description |
|:-------:|:----------|:-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |

### 👥 Employees
| Method | Endpoint | Description | Access |
|:-------:|:----------|:-------------|:---------|
| GET | `/api/employees` | Get all employees | Admin/User |
| GET | `/api/employees/{id}` | Get employee by ID | Admin/User |
| POST | `/api/employees` | Add a new employee | Admin |
| PUT | `/api/employees/{id}` | Update employee details | Admin |
| DELETE | `/api/employees/{id}` | Delete employee | Admin |

### 🏢 Departments
| Method | Endpoint | Description | Access |
|:-------:|:----------|:-------------|:---------|
| GET | `/api/departments` | Get all departments | Admin/User |
| POST | `/api/departments` | Add new department | Admin |

### 🎭 Roles
| Method | Endpoint | Description | Access |
|:-------:|:----------|:-------------|:---------|
| GET | `/api/roles` | Get all roles | Admin/User |
| POST | `/api/roles` | Add new role | Admin |

---

## 🧪 Testing with Postman

### 1️⃣ Register a User
**POST** → `http://localhost:8080/api/auth/register`  
**Body (JSON):**
```json
{
  "username": "rahul",
  "password": "123456"
}
```
### 2️⃣ Login and Get JWT Token

**POST** → `http://localhost:8080/api/auth/login`
**Body (JSON):**
```json
{
  "username": "rahul",
  "password": "123456"
}
```
### 3️⃣ Add a Department (Admin)

**POST** → `http://localhost:8080/api/departments`
**Header**: Authorization: Bearer <your_token>
**Body (JSON):**
```json
{
  "name": "Human Resources"
}
```
### 4️⃣ Add an Employee (Admin)

**POST** → `http://localhost:8080/api/employees`
**Header**: Authorization: Bearer <your_token>
**Body (JSON):**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 55000,
  "departmentId": 1,
  "roleId": 1
}
```
### 5️⃣ Get All Employees

**GET** → http://localhost:8080/api/employees
**Header**: Authorization: Bearer <your_token>

---

## 🏁 Project Conclusion

The **Employee Management System** is a robust backend solution built using **Java Spring Boot**, focusing on efficient management of employees, departments, and roles within an organization.  
It demonstrates core backend engineering principles like **secure authentication (JWT)**, **RESTful API design**, and **database management** using **Spring Data JPA**.  

This project reflects:
- Strong understanding of **Spring Boot architecture** and **backend API development**.  
- Implementation of **JWT-based authentication** for secure access.  
- Use of **MySQL** with **Hibernate/JPA** for smooth ORM mapping.  
- Scalable and maintainable structure with clear separation of concerns.  

💡 *This system provides a solid foundation for enterprise-grade HR or employee management applications.*

---

## 🚀 Future Enhancements

Planned improvements and advanced features that can be added in future versions:

- 📊 **Dashboard Analytics:** Add graphical reports for employee statistics and department performance.  
- 💬 **Email Notifications:** Automatically notify employees of important updates or changes.  
- 📁 **File Uploads:** Allow uploading of employee documents and profile pictures.  
- 🧠 **Role-Based Dashboard:** Different interfaces for Admin and Users.  
- ☁️ **Cloud Deployment:** Host the application on AWS or Azure for real-world scalability.  
- 🔐 **OAuth Integration:** Add Google or GitHub login for easier access.  

---

## 📞 Contact Details

**👨‍💻 Developer:** Sudesh Jadhav  
**📧 Email:** [sudeshjadhavv@gmail.com](mailto:sudeshjadhavv@gmail.com)  
**🔗 GitHub:** [https://github.com/sudeshjadhavv](https://github.com/sudeshjadhavv)  
**🌐 Portfolio:** [https://sudeshjadhavv.github.io/](https://sudeshjadhavv.github.io/)  

---

✨ *If you found this project helpful, don’t forget to ⭐ star the repository and connect with me for collaboration!*  
