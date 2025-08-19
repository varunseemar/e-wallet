# 💳 E-Wallet Application

This is a **Spring Boot based REST API** for an **e-wallet system**.  
It provides functionality for **user management, wallet transactions, payments, and secure authentication with JWT tokens**.

---

## ✨ Features

- 🔹 Creating and managing users  
- 🔹 Adding funds to wallets  
- 🔹 Making transactions between users  
- 🔹 Viewing user transaction history  
- 🔹 **JWT-based Authentication & Authorization**  

---

## 🚀 Tech Stack

- Java 17+  
- Spring Boot  
- Spring Security + **JWT (JSON Web Tokens)**  
- Spring Data JPA / Hibernate  
- PostgreSQL (or any SQL DB)  
- Maven  

---

## 📂 Project Structure (Controllers Overview)

- **AuthController** → Handles user login & JWT token generation  
- **UserController** → Handles user CRUD operations (secured with JWT)  
- **TransactionController** → Handles money transfers and transaction history (secured with JWT)  
- **WalletController** → Handles wallet balance and fund addition (secured with JWT)  

---

## ⚙️ Prerequisites

- Java 17 or above  
- Maven 3.8+  
- PostgreSQL/MySQL installed  
- IDE like IntelliJ / Eclipse  

Update `application.properties` or `application.yml` with your DB configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/e_wallet
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Secret & Expiration
jwt.secret=your_base64_encoded_secret_key
jwt.expiration=18000000
```

---

## 🛠️ Setup Instructions

Clone repo:

```bash
git clone https://github.com/yourusername/e-wallet-springboot.git
cd e-wallet-springboot
```

Build project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Access API Docs (Optional if using Swagger):

```
http://localhost:8080/swagger-ui.html
```

---

## 🔑 Authentication & JWT

### 1. Register a User
```json
POST /auth/register
{
  "name": "Alice",
  "email": "alice@email.com",
  "password": "securePass123"
}
```

### 2. Login & Get Token
```json
POST /auth/login
{
  "email": "alice@email.com",
  "password": "securePass123"
}
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9..."
}
```

### 3. Use Token in Requests
All secured endpoints require an **Authorization header**:

```
Authorization: Bearer <your_token_here>
```

---

## 📘 API Endpoints

### 👤 User APIs (JWT Protected)

| Method | Endpoint       | Description        |
|--------|---------------|--------------------|
| POST   | /user/add     | Create new user    |
| GET    | /user/{id}    | Get user by ID     |
| PATCH  | /user/{id}    | Update user details |
| DELETE | /user/{id}    | Delete user by ID  |

---

### 💸 Transaction APIs (JWT Protected)

| Method | Endpoint                  | Description                    |
|--------|---------------------------|--------------------------------|
| POST   | /transaction/send        | Send money (create transaction)|  
| GET    | /transaction/{id}        | Get transaction by ID          |  
| GET    | /transaction/getAll/{userId} | Get all transactions for a user |  

---

### 🏦 Wallet APIs (JWT Protected)

| Method | Endpoint             | Description                          |
|--------|----------------------|--------------------------------------|
| POST   | /payment/add_money   | Add money to logged-in user’s wallet |

---

## ✅ Future Enhancements

- 📊 Wallet balance & transaction analytics endpoints  
- 🌍 Support for multiple currencies  
- 📱 Mobile app integration  

---

## 👨💻 Author

**Varun Seemar**  
Full Stack Engineer | Java & Spring Boot Developer | MERN Full Stack Developer  
