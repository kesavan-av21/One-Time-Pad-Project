# One-Time Pad (OTP) Encryption System

A **Spring Boot + Java backend application** with a **frontend (HTML/CSS/Node.js)** for secure message encryption and decryption using the **One-Time Pad (OTP)** technique.  
This project demonstrates **cryptography fundamentals, API design, and frontend-backend integration**.

---

## Overview
The **One-Time Pad Encryption System** is a secure application built with **Spring Boot (backend)** and a **frontend client**.  
It generates a **random encryption key** (pad) for each message, ensuring **unbreakable encryption** when keys are used only once.  

This project demonstrates:

- Strong use of **cryptographic randomness** (`SecureRandom`).  
- RESTful APIs for **key generation, encryption, and decryption**.  
- Integration with a **simple frontend** for user interaction.  
- Secure transfer of encrypted text between client and server.  
- Clean and modular project structure.  

---

## Key Features
- 🔐 **Encryption/Decryption** using One-Time Pad (OTP).  
- 🎲 **Secure Random Key Generation** with `SecureRandom`.  
- 🌐 **Spring Boot REST API** for OTP operations.  
- 🖥️ **Frontend (HTML, CSS, Node.js)** for testing and usage.  
- 🛡️ **Stateless and secure design** (no key reuse).  

---

## Project Structure

```text
OneTimePad/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── onetimepad/
│   │   │               ├── OneTimePadApplication.java
│   │   │               │   └── CreateOneTimePadController.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── onetimepad/
│                       └── OneTimePadApplicationTests.java
│
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── server.js
│
├── README.md
├── .gitignore
├── pom.xml

```
## Technologies Used
### Backend
- Java 17+  
- Spring Boot 3+  
- Spring Web  
- Maven  

### Frontend
- HTML, CSS, JavaScript  
- Node.js (for running frontend server)  

---

## Setup Instructions

### Backend (Spring Boot)

  1. Navigate to the backend folder:
   
   cd OneTimePad/OneTimePad

  2. Run the Spring Boot application:
    mvn spring-boot:run

  3. The backend will start at:
    http://localhost:8080

### Frontend

  1.  Navigate to the frontend folder:    

    cd frontend/frontend

  2. Install dependencies and run server:

    npm install
    node server.js  

  3. Access frontend at:

    http://localhost:3000  

### API Endpoints    

| Method | Endpoint        | Description                 |
| ------ | --------------- | --------------------------- |
| GET    | `/otp/generate` | Generates a random OTP key  |
| POST   | `/otp/encrypt`  | Encrypts a given plaintext  |
| POST   | `/otp/decrypt`  | Decrypts a given ciphertext |

### Future Enhancements

 - Add database persistence for OTP usage tracking.

 - Improve UI with React/Angular frontend.

 - Add user authentication for secure key exchange.
