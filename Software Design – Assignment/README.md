# Software Design – Assignment

| Field | Details |
| --- | --- |
| **Student Name** | MD Samir Tahrian |
| **Student ID** | IT24007 |
| **Course** | Software Engineering |
| **Topic** | Software Design |
| **Level** | Bachelor (BNQF Level 6) |
| **Full Marks** | 40 |

## Contents

- [Question 1: Short Questions](#question-1-short-questions-10-marks)
- [Question 2: Modularity, Coupling and Cohesion](#question-2-modularity-coupling-and-cohesion-3-marks)
- [Question 3: Design Quality Metrics](#question-3-design-quality-metrics-4-marks)
- [Question 4: Architectural Styles](#question-4-architectural-styles-4-marks)
- [Question 5: The Composite Pattern](#question-5-the-composite-pattern-5-marks)
- [Question 6: Adapter and Facade Patterns](#question-6-adapter-and-facade-patterns-6-marks)
- [Question 7: Enterprise Application Architecture](#question-7-enterprise-application-architecture-4-marks)
- [Question 8: Inheritance Mapping](#question-8-inheritance-mapping-4-marks)

---

## Question 1: Short Questions (10 Marks)

### (a) Define abstraction and information hiding (encapsulation). [2]

**Abstraction** is a view of an object that focuses only on the information relevant to a particular purpose and ignores the rest.

**Information hiding (encapsulation)** means grouping and packaging the internal details of an abstraction so that external entities cannot access them.

### (b) State what CBO counts and how WMC is calculated. [2]

**CBO (Coupling Between Objects)** counts the number of classes used by a given class. Inheritance is typically not counted.

**WMC (Weighted Methods per Class)** is the sum of the complexities of all the methods in a class. Here, N is the number of methods and Cᵢ is the complexity of method i.

$$
WMC(A) = \sum_{i=1}^{N} C_i
$$

### (c) Identify the architectural style shown by the following UNIX command. [1]

```bash
ls -l | grep "Aug" | sort +4n | more
```

This command demonstrates the **Pipes and Filters** architectural style.

### (d) Name the three categories of GoF patterns, and state the category of Adapter, Composite and Facade. [2]

The three categories are **Creational, Structural and Behavioral**. Adapter, Composite and Facade are all **Structural** patterns.

### (e) State the intent of the Strategy pattern. [1]

The Strategy pattern defines a family of algorithms, encapsulates each one and makes them interchangeable. This allows an algorithm to vary independently of the clients that use it.

### (f) State the purpose of the Identity Field pattern and what it stores. [2]

Its **purpose** is to maintain the identity link between an in-memory object and a database table row. To do this, the object **stores the database ID (primary key)** in one of its fields.

---

## Question 2: Modularity, Coupling and Cohesion (3 Marks)

### (a) Explain modularity and decomposition. [1]

Modularity and decomposition mean dividing a large software system into smaller, named components. These components have well-defined interfaces that describe how they interact. Different functions and responsibilities are usually placed in different components.

### (b) Describe how coupling and cohesion are used to judge a decomposition. [2]

**Coupling** measures the interdependence among components. A good decomposition has **low coupling**, which means its components do not depend heavily on one another.

**Cohesion** measures how strongly the elements within a component are associated. A good decomposition has **high cohesion**, which means the elements of each component belong closely together.

---

## Question 3: Design Quality Metrics (4 Marks)

### (a) Explain how LCOM is determined from the sets P and Q. [2]

**LCOM (Lack of Cohesion of Methods)** is found by examining every pair of methods in a class.

- **P** is the set of method pairs that do not use common attributes.
- **Q** is the set of method pairs that use common attributes.

$$
LCOM = \begin{cases} |P| - |Q|, & \text{if } |P| > |Q| \\ 0, & \text{otherwise} \end{cases}
$$

### (b) Explain the LCOM2 formula and the meaning of the values 0 and 1. [2]

$$
LCOM2 = 1 - \frac{\sum_{i=1}^{a} m_{A_i}}{m \times a}
$$

- **m** is the number of methods in the class.
- **a** is the number of attributes in the class.
- **m(Aᵢ)** is the number of methods that use attribute Aᵢ. Its maximum value is m.

A smaller value indicates better cohesion.

- **LCOM2 = 0:** Every method uses every attribute, so cohesion is at its highest.
- **LCOM2 = 1:** No method uses any attribute, so cohesion is at its lowest.

---

## Question 4: Architectural Styles (4 Marks)

### (a) Compare the Layered and Event-Based architectural styles. [2]

| Basis | Layered Style | Event-Based Style |
| --- | --- | --- |
| **Organisation** | Components are arranged in layers. | Components act as event producers and event consumers. |
| **Interaction** | Each layer depends only on the next layer. | Consumers register for events, which are then distributed to them and consumed. |

### (b) Explain the roles of the Model, View and Controller in MVC. [2]

- **Model:** It represents information about the problem domain.
- **View:** It displays the model in the user interface.
- **Controller:** It receives user input, manipulates the model and causes the view to update appropriately.

Together, the View and the Controller form the user interface.

---

## Question 5: The Composite Pattern (5 Marks)

### (a) Explain the intent of the Composite pattern. [1]

The Composite pattern arranges objects into structures that represent **part–whole hierarchies**. It lets clients treat individual objects and groups of objects **in the same way**.

### (b) Describe the roles of its four participants. [2]

- **Component (Graphic):** It declares the common interface for all objects in the composition and implements default behaviour common to all classes.
- **Primitive (Rectangle):** It is a leaf object, so it has no children. Line and Text are also primitives.
- **Composite (Picture):** It defines the behaviour of components that have children. For example, a Picture can contain Rectangles.
- **Client:** It works with all objects in the composition through the Component (Graphic) interface.

### (c) Explain one benefit and one liability. [2]

**Benefit:** Client code becomes simpler. The client can treat a single Rectangle and a complete Picture uniformly.

**Liability:** The design can become too general. Because adding components is easy, it is harder to restrict what a composite may contain.

---

## Question 6: Adapter and Facade Patterns (6 Marks)

### (a) Compare the intent of the two patterns. [2]

| Adapter | Facade |
| --- | --- |
| Converts the interface of a class into another interface that clients expect. | Provides a unified, higher-level interface to a set of interfaces in a subsystem. |
| Allows classes with incompatible interfaces to work together. | Makes the subsystem easier to use. |

### (b) Compare their participants and roles. [2]

**Adapter pattern**

- **Target (Shape):** It defines the interface that the client uses.
- **Client (DrawingEditor):** It works with objects that follow the Target interface.
- **Adaptee (TextView):** It is the existing interface that needs to be adapted.
- **Adapter (TextShape):** It adapts the Adaptee's interface to the Target interface.

**Facade pattern**

- **Facade (Compiler):** It knows which subsystem classes can handle a request and passes the request to them.
- **Subsystem classes (Scanner, Parser and others):** They perform the actual work and have no knowledge of the Facade.

### (c) Explain one benefit of Adapter and one liability of Facade. [2]

**Adapter benefit:** Adaptees can be added and used without changing existing code. This makes it easier to reuse existing classes.

**Facade liability:** The Facade can grow into an overly complex **God class** that is difficult to manage.

---

## Question 7: Enterprise Application Architecture (4 Marks)

### (a) Explain the Domain Model pattern and where it is suitable. [2]

A **Domain Model** is an object model of the problem domain that includes both **data and behaviour**. In this model, each table row (tuple) is represented by a different object.

It is suitable for applications with **complex business logic**. A network of connected objects, each representing a meaningful concept, handles the business rules.

### (b) Explain the key idea of ORM and the responsibility of Data Mapper. [2]

**Object-Relational Mapping (ORM)** maps objects to database relations and vice versa. Its key idea is to use one database table for each domain class and to store each object as a row in that table.

The **Data Mapper**, also known as a Repository or DAO, is a layer of mappers that transfers data between objects and the database. It keeps the objects and the database independent of each other and of the mapper. The objects do not even need to know that a database exists.

---

## Question 8: Inheritance Mapping (4 Marks)

### (a) Explain how the two patterns represent a hierarchy in the database. [2]

**Single Table Inheritance** stores the whole class hierarchy in **one table**. The table has columns for all the fields of all the classes.

**Class Table Inheritance** uses **one table for each class** in the hierarchy. These tables are linked by foreign keys.

### (b) Compare the two patterns. [2]

| Basis | Single Table Inheritance | Class Table Inheritance |
| --- | --- | --- |
| **(i) Retrieving an object** | Only one table is needed, so no join is required. | Several tables are needed. This requires a join, or multiple queries whose results are combined in memory. |
| **(ii) Moving fields up or down the hierarchy** | The database does not need to change. | The database must be changed. |
