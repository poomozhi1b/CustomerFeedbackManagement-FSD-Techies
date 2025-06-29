# Customer Feedback System

## 📋 Project Description
The **Customer Feedback System** is a Java-based console application that 
allows users to submit feedback and ratings for different domains such as
FSD, WD, IMS, SD, and MAYA. Admins can view, respond to, and manage the
feedback.The systemalso identifies the top-rated domain based on average ratings

---


### 👥 User Module
- User Registration and Login
- Submit Feedback with rating (1 to 5)
- View Own Feedback and Admin Responses

### 🛠️ Admin Module
- Admin Login
- View All Feedback
- Respond to Feedback
- Delete Feedback
- View Top-Rated Domain (Based on Average Rating)

---

## 🧑‍💻 Technologies Used
- Java (JDK 17+)
- JDBC (Java Database Connectivity)
- MySQL
- Eclipse/IntelliJ (or any IDE)

---
## 🗂️ Project Structure
CustomerFeedbackSystem/
│
├── app/ #  Main Application Entry Point
│ └── App.java 
│
├── model/ # POJO Classes
│ ├── User.java
│ └── Feedback.java
│
├── dao/ # JDBC and SQL Operations
│ ├── UserDAO.java
│ └── FeedbackDAO.java
│
├── service/ # Business Logic
│ ├── UserService.java
│ └── AdminService.java
│
├── util/ # Utilities 
│ └── DBManager.java

---

## 🧠 OOP Concepts Used
- **Encapsulation**: User and Feedback classes with private fields and getters/setters.
- **Abstraction**: Separation of logic into service and DAO layers.
- **Inheritance**: Can be used in future for extending roles (User → Admin).
- **Polymorphism**: Method overloading for operations like viewing feedback.

---

## 🗃️ Database Schema

### Tables
- **User** (user_id, username, password)
- **Feedback** (feedback_id, user_id, domain, comment, rating)
  

---

## ⚙️ How to Run

1. Clone the repository
2. Set up the MySQL database with provided schema
3. Update DB credentials in `DBManager.java`
4. Compile and run `Main.java`

---

## 📌 Future Enhancements
- GUI using JavaFX or Swing
- Email notifications to users
- Pagination and filters for admin panel

---

## 📃 License
This project is for educational purposes.




Institution:
------------
KG College Of Arts And Science
Department of Computer Technology
Mini Project Submission – Full Stack Development
Submission Date: 30/06/2025# CustomerFeedbackManagement-FSD-Techies
