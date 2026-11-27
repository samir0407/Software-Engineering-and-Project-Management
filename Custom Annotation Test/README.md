# CampusBoot
### A Mini Annotation-Driven Java Framework Built from Scratch

---

**Developed By**

**MD Samir Tahrian**  
**Student ID:** IT 24007  
**Department:** Information and Communication Technology (ICT)  
**University:** Mawlana Bhashani Science and Technology University

---

> **Understanding Frameworks from the Inside Out — One Annotation at a Time.**

## 1. Project Overview

CampusBoot is a lightweight Java-based mini framework developed to explore the internal working mechanisms of modern annotation-driven frameworks such as Spring Boot.

Instead of directly using Spring Boot, this project implements selected framework concepts from scratch using Java Custom Annotations and the Reflection API.

It demonstrates how a framework can automatically register components, inject configuration values, validate object data, and handle routes through runtime annotation processing.

The main purpose of CampusBoot is to understand the fundamental technologies and mechanisms that make modern Java frameworks work.

## 2. Project Motivation

Frameworks like Spring Boot simplify application development by automating many repetitive tasks.

But have you ever wondered what happens behind annotations such as `@Component`, `@Value`, or route mappings?

CampusBoot was created to explore that question.

By implementing a simplified framework using core Java, this project provides practical experience with the concepts behind annotation-based application development.

**The core idea is simple: Understand how frameworks work before using them.**

## 3. Project Objectives

- Understand Java Custom Annotations and their purposes.
- Explore Java Reflection and runtime annotation processing.
- Build a basic IoC-style component container.
- Implement configuration-based field injection.
- Develop an annotation-driven validation system.
- Create a simple annotation-based routing mechanism.
- Understand the fundamental ideas behind Spring Boot.

## 4. Key Features

| Feature | Description |
|---|---|
| Component Scanning | Automatically identifies and registers annotated classes. |
| Configuration Injection | Injects configuration values into fields using annotations. |
| Custom Validation | Validates object fields based on defined constraints. |
| Dynamic Routing | Maps URL paths to methods using custom annotations. |
| Runtime Reflection | Inspects classes, fields, and methods during execution. |
| 404 Handling | Returns a not-found response for unknown routes. |

## 5. Custom Annotation System

CampusBoot introduces four custom annotations to control framework behavior.

| Annotation | Target | Purpose |
|---|---|---|
| `@Component` | Class | Marks a class for component registration. |
| `@Value` | Field | Identifies fields that receive configuration values. |
| `@Range` | Field | Defines minimum and maximum validation limits. |
| `@Route` | Method | Maps a method to a specific route path. |

All four annotations use runtime retention so that their metadata can be accessed through Java Reflection during program execution.

## 6. Framework Architecture

CampusBoot is organized around four major processing components.

### 6.1 Component Container

The `Container` manages component registration and configuration injection.

Responsibilities:

- Scans provided classes.
- Checks for the `@Component` annotation.
- Creates component instances.
- Stores registered components in a bean registry.
- Injects configuration values into annotated fields.

### 6.2 Configuration Injection

The framework uses `@Value` to identify fields that require configuration values.

The Container reads values from a configuration map and injects them into the appropriate fields using Reflection.

Example configuration:

```java
config.put("app.name", "CampusBoot");
config.put("app.passMark", "40");
```

### 6.3 Validation Engine

The `Validator` checks fields annotated with `@Range`.

It compares actual field values against the defined minimum and maximum limits and reports violations when values fall outside the allowed range.

### 6.4 Routing Engine

The `Router` searches registered components for methods annotated with `@Route`.

When a requested path matches an annotation path, the corresponding method is invoked through Reflection.

If no matching route exists, the framework returns a 404 Not Found response.

## 7. How CampusBoot Works

The framework follows this simplified execution flow:

```text
             APPLICATION START
                     |
                     v
             Configuration Setup
                     |
                     v
              Component Scanning
                     |
                     v
             Component Registration
                     |
                     v
            Configuration Injection
                     |
                     v
                 Validation
                     |
                     v
               Route Handling
                     |
                     v
              Application Output
```

Java Reflection connects these operations by allowing the framework to inspect annotation metadata and interact with classes, fields, and methods at runtime.

## 8. Technology Stack

| Technology | Usage |
|---|---|
| Java 11+ | Core programming language |
| Apache Maven | Project build and dependency management |
| Java Reflection API | Runtime inspection and invocation |
| Custom Annotations | Framework behavior definition |
| NetBeans IDE | Development environment |

**Note:** CampusBoot is implemented using standard Java features. The actual Spring Boot framework is not used as a dependency.

## 9. Project Structure

```text
CampusBoot/
│
├── pom.xml
├── README.md
├── answers.txt
│
└── src/
    └── main/
        └── java/
            └── com/
                └── mycompany/
                    └── campusboot/
                        │
                        ├── CampusBoot.java
                        ├── Component.java
                        ├── Value.java
                        ├── Range.java
                        ├── Route.java
                        │
                        ├── Main.java
                        ├── Container.java
                        ├── GradeController.java
                        ├── ReportPrinter.java
                        ├── Student.java
                        ├── Validator.java
                        └── Router.java
```

## 10. Execution Preview

The following output demonstrates the successful execution of CampusBoot.

### Component Registration & Injection

```text
[Container] Registered: gradeController (GradeController)
[Container] Skipped: ReportPrinter (no @Component)
[Container] Injected: app.name -> GradeController.appName
[Container] Injected: app.passMark -> GradeController.passMark
```

### Validation Results

```text
--- Validation ---
VIOLATION: score - Score must be between 0 and 100 (actual: 120)
OK
VIOLATION: semester - Value out of range (actual: 15)
```

### Routing Results

```text
--- Routing ---
[Router] /hello -> Welcome to CampusBoot
[Router] /status -> Pass mark is 40
[Router] /unknown -> 404 Not Found: /unknown
```

### Build Status

```text
BUILD SUCCESS
```

## 11. Getting Started

Follow these steps to run CampusBoot on your local machine.

### Prerequisites

- Java JDK 11 or later
- Apache Maven
- NetBeans IDE (recommended)

### Step 1: Clone the Repository

```bash
git clone https://github.com/samir0407/CampusBoot.git
```

### Step 2: Open the Project

Open NetBeans and import the downloaded folder as a Maven project.

### Step 3: Run the Application

Open `Main.java` and run the project.

Alternatively, run the following command from the project directory:

```bash
mvn compile exec:java -Dexec.mainClass="com.mycompany.campusboot.Main"
```

## 12. Testing and Verification

The project was executed successfully and the following operations were verified:

- Component registration and skipping.
- Configuration value injection.
- Validation of valid and invalid data.
- Successful route matching.
- Handling of unknown routes.
- Successful Maven execution.

The application produced the expected sample output and completed with `BUILD SUCCESS`.

## 13. Learning Outcomes

Developing CampusBoot provided practical experience in:

- Designing custom Java annotations.
- Understanding `RetentionPolicy.RUNTIME`.
- Working with the Java Reflection API.
- Creating a basic IoC-style container.
- Implementing configuration value injection.
- Performing annotation-based data validation.
- Invoking methods dynamically through Reflection.
- Understanding selected internal concepts of Spring Boot.

## 14. Project Scope and Limitations

CampusBoot is an educational mini-framework designed to demonstrate selected concepts of annotation-driven frameworks.

It is not a replacement for Spring Boot and does not provide its complete functionality, such as production-grade dependency injection, embedded web servers, advanced auto-configuration, or enterprise-level application management.

The project focuses on understanding the underlying concepts through a simplified implementation.

## 15. Reflection Documentation

The `answers.txt` file contains the theoretical reflection answers required by the assignment.

It covers:

- The importance of Runtime Retention.
- How CampusBoot demonstrates basic Spring Boot concepts.
- The role of Java Reflection in the Container.

---

<p align="center">

### Built with Java. Powered by Reflection. Inspired by Framework Internals.

**CampusBoot — Learn the Mechanism, Build the Framework.**

</p>
