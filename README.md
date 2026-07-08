<div align="center">

# 🍓 Bella Bites
### Bakery Management System

A full-stack web application for managing bakery operations — built from the ground up with Java Spring Boot, SQL Server, and vanilla JavaScript.

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.15-brightgreen?style=flat-square&logo=springboot)
![SQL Server](https://img.shields.io/badge/SQL%20Server-Express-red?style=flat-square&logo=microsoftsqlserver)
![License](https://img.shields.io/badge/License-Academic-blue?style=flat-square)

</div>

---

## 📖 About

Bella Bites is an internal management tool designed for a bakery owner and their staff — **not** a customer-facing storefront. It replaces spreadsheets and paper logs with a single dashboard for tracking products, customers, orders, and staff, complete with role-based access so admins and employees only see what's relevant to them.

This project was built as a hands-on way to learn full-stack development: connecting a real database to a Spring Boot backend, and wiring that up to a live, responsive frontend.

---

## ✨ Features

### 🧁 Inventory & Sales
- Add, edit, and delete products with live stock tracking
- **Cart-based order system** — add multiple products with quantities, auto-calculated totals, and automatic stock deduction on checkout
- Stock validation prevents orders from exceeding available inventory
- Low-stock alert banner (triggers under 5 units)
- Best-sellers ranking on the dashboard

### 🧑‍🤝‍🧑 People Management
- Full CRUD for customers, staff, and categories
- Phone number validation (digits only, 10–12 characters)
- Order assignment — admins assign orders to specific employees

### 🔐 Security & Roles
- Spring Security with BCrypt-encrypted passwords
- Separate Admin and Employee login flows
- Role-protected routes (`/admin/**`, `/employee/**`)
- Employees see only their own assigned orders and can update order status in real time

### 📊 Dashboard
- Live revenue tracking
- Recent order feed
- Clean, warm-toned custom UI (no framework — hand-built HTML/CSS)

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| **Frontend** | HTML5, CSS3, Vanilla JavaScript |
| **Backend** | Java 21, Spring Boot 3.5.15, Maven |
| **Database** | Microsoft SQL Server (Express) |
| **ORM** | Spring Data JPA / Hibernate |
| **Security** | Spring Security 6, BCrypt |
| **Templating** | Thymeleaf (login page & employee dashboard) |

---

## 📁 Project Structure

```
bakery-management/
├── src/main/java/com/bakery/bakery_management/
│   ├── model/          → Product, Customer, Employee, Orders, OrderItem, User...
│   ├── repository/     → Spring Data JPA interfaces
│   ├── controller/     → REST endpoints
│   └── security/       → Spring Security config, UserDetailsService, seeder
├── src/main/resources/
│   ├── static/          → index.html (landing page), dashboard.html (admin panel)
│   ├── templates/       → login.html, employee-dashboard.html (Thymeleaf)
│   └── application.properties   (excluded from Git — see setup below)
└── pom.xml
```

---

## 🚀 Getting Started

### Prerequisites
- Java 21 (JDK)
- Maven
- SQL Server (Express is fine) with SQL Server Authentication enabled

### 1. Clone the repo
```bash
git clone https://github.com/Ubairapatujo/Bella-Bites.git
cd Bella-Bites
```

### 2. Configure your database
Create `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:sqlserver://localhost:YOUR_PORT;databaseName=BakeryManagement;encrypt=true;trustServerCertificate=true
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
server.port=8080
```
> 🔒 This file is gitignored on purpose — never commit real database credentials.

### 3. Set up the tables
Run the table creation scripts in SQL Server Management Studio (SSMS) for: `product`, `Category`, `Customer`, `Employee`, `Orders`, `OrderItem`, and `users`.

### 4. Run it
```bash
./mvnw spring-boot:run
```
Then visit **http://localhost:8080**

### Default Credentials
| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin123` |
| Employee | `employee1` | `emp123` |

> ⚠️ Change these before using in any real deployment.

---

## 🗺️ Roadmap

- [ ] Edit functionality for categories
- [ ] Date-range filters on order history
- [ ] PDF export for order receipts

---

## 👤 Author

**Ubaira Patujo**
Computer Science student, NED University of Engineering & Technology — Karachi, Pakistan

---

<div align="center">

*Built as a learning project — full stack, from database to browser.*

</div>
