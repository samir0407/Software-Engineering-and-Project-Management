# 🎮 SAMIR WHIZ

A web-based mathematical quiz game developed using **Java Servlet, JSP, JDBC, MySQL, and Apache Tomcat**.

Players enter their names, answer mathematical questions, receive a score out of 10, and view their ranking on the leaderboard.

---

# 📌 Project Objectives

- Develop reusable Java methods for mathematical calculations.
- Apply prime number validation logic.
- Perform modulus calculations.
- Use trigonometric functions with Java Math class.
- Implement Servlet request and response processing.
- Connect Java web applications with MySQL using JDBC.
- Store and retrieve player scores from a database.
- Display the Top 10 players using a leaderboard.

---

# 🛠 Technologies Used

- Java
- JSP
- Servlet
- JDBC
- MySQL
- Apache Tomcat
- NetBeans IDE
- Laragon
- HTML
- CSS

---

# 📁 Project Structure

```text
SamirWhiz
│
├── src
│   └── main
│       ├── java
│       │   ├── controller
│       │   │   └── GameServlet.java
│       │   ├── dao
│       │   │   └── ScoreDAO.java
│       │   ├── model
│       │   │   └── GameScore.java
│       │   └── service
│       │       └── MathService.java
│       │
│       └── webapp
│           ├── index.jsp
│           ├── game.jsp
│           ├── result.jsp
│           ├── leaderboard.jsp
│           └── css
│               └── style.css
│
├── database
│   └── samir_whiz_db.sql
│
└── README.md
```

---

# 🗄 Database Configuration

### Database Name

```sql
samir_whiz_db
```

### Table Name

```sql
game_scores
```

---

# 💾 Database SQL Script

```sql
CREATE DATABASE samir_whiz_db;

USE samir_whiz_db;

CREATE TABLE game_scores(
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(100),
    score INT,
    difficulty VARCHAR(20),
    played_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

# 🎯 Game Rules

| Question | Topic | Marks |
|-----------|---------|---------|
| Q1 | Prime Number | 2 |
| Q2 | Modulus Operation | 2 |
| Q3 | Trigonometry | 3 |
| Q4 | Trigonometry | 3 |
| **Total** |  | **10** |

---

# ✅ Features

- Prime Number Validation
- Modulus Calculation
- Trigonometric Calculations
- Multiple Choice Questions (MCQ)
- Score Calculation
- JDBC Database Connectivity
- MySQL Integration
- Store Player Name and Score
- Difficulty Level Storage
- Date and Time Storage
- Top 10 Leaderboard
- Rank Display
- Responsive User Interface

---

# 🏆 Leaderboard Query

```sql
SELECT *
FROM game_scores
ORDER BY score DESC, played_at ASC
LIMIT 10;
```

---

# ▶ How to Run

### Step 1

Start Laragon.

### Step 2

Start MySQL Server.

### Step 3

Create the database using the SQL script provided above.

### Step 4

Open the project in NetBeans IDE.

### Step 5

Configure Apache Tomcat.

### Step 6

Run the project.

### Step 7

Open:

```text
http://localhost:8080/SamirWhiz
```

### Step 8

Enter player name.

### Step 9

Answer the questions.

### Step 10

Submit answers and view your score.

### Step 11

Open the leaderboard to view rankings.

---

# 📸 Application Screenshots

## Welcome Page

![Welcome Page](screenshots/home.png)

---

## Game Page

![Game Page](screenshots/game.png)

---

## Result Page

![Result Page](screenshots/result.png)

---

## Leaderboard

![Leaderboard](screenshots/leaderboard.png)

---

# 📚 Learning Outcomes

After completing this project, students will be able to:

- Create Java Web Applications.
- Use JSP and Servlets.
- Perform mathematical calculations in Java.
- Connect Java applications with MySQL.
- Use JDBC for database operations.
- Store and retrieve records securelyGitHub.

---

# 👨‍💻 Author

**Samir**

---

