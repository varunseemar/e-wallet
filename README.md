# 💳 E-Wallet Application

This is a **Spring Boot based REST API** for an **e-wallet system**.  
It provides functionality for **user management, wallet transactions, and payments**.

---

## ✨ Features

- 🔹 Creating and managing users  
- 🔹 Adding funds to wallets  
- 🔹 Making transactions between users  
- 🔹 Viewing user transaction history  

---

## 🚀 Tech Stack

- Java 17+  
- Spring Boot  
- Spring Security (for authentication)  
- Spring Data JPA / Hibernate  
- PostgreSQL (or any SQL DB)  
- Maven  

---

## 📂 Project Structure (Controllers Overview)

- **UserController** → Handles user CRUD operations  
- **TransactionController** → Handles money transfers and transaction history  
- **WalletController** → Handles wallet balance and fund addition  

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

## 📘 API Endpoints

### 👤 User APIs

| Method | Endpoint       | Description        |
|--------|---------------|--------------------|
| POST   | /user/add     | Create new user    |
| GET    | /user/{id}    | Get user by ID     |
| PATCH  | /user/{id}    | Update user details |
| DELETE | /user/{id}    | Delete user by ID  |

📌 Example Request (Create User):

```json
POST /user/add
{
  "name": "Alice",
  "email": "alice@email.com",
  "password": "securePass123"
}
```

---

### 💸 Transaction APIs

| Method | Endpoint                  | Description                    |
|--------|---------------------------|--------------------------------|
| POST   | /transaction/send        | Send money (create transaction)|
| GET    | /transaction/{id}        | Get transaction by ID          |
| GET    | /transaction/getAll/{userId} | Get all transactions for a user |

📌 Example Request (Send Money):

```json
POST /transaction/send
{
  "senderId": "1",
  "receiverId": "2",
  "amount": 500
}
```

---

### 🏦 Wallet APIs

| Method | Endpoint             | Description                        |
|--------|----------------------|------------------------------------|
| POST   | /payment/add_money   | Add money to logged-in user's wallet |

📌 Example Request (Add Money):

```text
POST /payment/add_money?amount=1000
```
(Requires authentication → Spring Security UserDetails.)

---

## ✅ Future Enhancements

- 🔐 JWT Authentication for secure API access  
- 📊 Wallet balance & transaction analytics endpoints  
- 🌍 Support for multiple currencies  
- 📱 Mobile app integration  

---

## 👨💻 Author

**Varun Seemar**  
Full Stack Engineer | Java & Spring Boot Developer | MERN Full Stack Developer 
