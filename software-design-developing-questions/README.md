# Software Design: Developing Questions

**Course:** Software Engineering (SE)

**Topic:** Software Design (Design Fundamentals, Architecture, Design Patterns, UI Design)

**Prepared by:** MD. Samir Tahrian, ID: IT-24007

**Department:** Information and Communication Technology (ICT), Mawlana Bhashani Science and Technology University (MBSTU), Santosh, Tangail

**Source material:** *SoftEng-Design.pdf* (155 slides)

---

## 1. Assessment Specification (OBE-based)

| Item | Detail |
|---|---|
| Approach | Outcome-Based Education (OBE) |
| Taxonomy | Bloom's Taxonomy (Cognitive Domain) |
| Standard | BNQF (Bangladesh National Qualifications Framework) |
| Cognitive levels used | **C1: Knowledge (Remember)** and **C2: Understanding (Comprehend)** |
| Total marks | **40** |
| Number of questions | **8** (all compulsory, 5 marks each) |
| Duration | **1 hour (60 minutes)** |
| Number of COs | 5 (CO1 to CO5) |

---

## 2. Course Outcomes (CO) for the Software Design Unit

| CO | Course Outcome | Covered slide topics |
|---|---|---|
| **CO1** | Explain the concept, steps and outcome of software design. | What is software design, architectural vs detailed design, design outcome and rationale, what makes a good design |
| **CO2** | Describe design principles (modularity, coupling, cohesion, abstraction, encapsulation) and design quality metrics. | Modularity and decomposition, coupling and cohesion (with their types), information hiding, design reviews, CK metrics (CBO, LCOM, WMC, RFC, DIT, NOC) |
| **CO3** | Explain software architecture, architectural styles and enterprise application architecture patterns. | Software architecture, layered, event-based, MVC, blackboard, pipes and filters; Fowler's EAA patterns (Domain Model, Service Layer, Data Mapper, ORM, inheritance mapping, presentation patterns) |
| **CO4** | Describe GoF design patterns with their intent, structure, benefits and liabilities. | Factory Method, Prototype, Singleton, Strategy, Template Method, Adapter, Composite, Facade, Command, Decorator, Observer |
| **CO5** | Explain user interface design principles, interaction modalities and information presentation. | UI design principles, UI modalities, use of colour |

---

## 3. Questions (Answer ALL questions. Each question carries 5 marks.)

**Q1.** (a) What is software design? What is the input of the design process? *(2)*

(b) Distinguish between architectural design and detailed design. *(1.5)*

(c) What is the outcome of the design process? Why is the rationale of each non-trivial decision recorded? *(1.5)*

**Q2.** (a) What is modularity and decomposition in software design? *(1)*

(b) Define coupling and cohesion. Why do we want low coupling and high cohesion? *(2)*

(c) List the types of coupling (from low to high) and the types of cohesion (from low to high) with a short description of each. *(2)*

**Q3.** (a) Explain abstraction, encapsulation and information hiding. *(2)*

(b) How is the quality of a software design assessed? Explain any three Chidamber and Kemerer (CK) metrics from the following and state what each measures: CBO, LCOM, WMC, RFC, DIT, NOC. *(3)*

**Q4.** (a) Define software architecture. *(1)*

(b) Explain any three of the following architectural styles with the role of their components: Layered, Event-based, Model-View-Controller (MVC), Blackboard/Repository, Pipes and Filters. *(4)*

**Q5.** (a) Name the three layers of an enterprise application and state the responsibility of each. *(1.5)*

(b) Explain the Domain Model, Service Layer and Data Mapper patterns (what each one is and when it is used). *(2)*

(c) Describe the three ways of mapping an inheritance hierarchy to database tables: Single Table, Class Table and Concrete Table Inheritance. *(1.5)*

**Q6.** (a) What is a design pattern? Name the three categories of GoF patterns with two examples of each. *(1.5)*

(b) Explain the Factory Method pattern: intent, participants and one benefit. *(1.5)*

(c) State the intent of the Prototype and Singleton patterns, and one liability of each. *(2)*

**Q7.** Explain **any two** of the following patterns: Strategy, Template Method, Adapter, Composite, Facade, Command, Decorator, Observer. For each pattern write: (i) intent, (ii) main participants, (iii) one benefit and one liability. *(2.5 + 2.5)*

**Q8.** (a) List and briefly explain any four UI design principles. *(2)*

(b) Name and explain any three UI interaction modalities (for example question-answer, direct manipulation, menu selection, form fill-in, command language, natural language). *(2)*

(c) State any two guidelines for using colour in presenting information to users. *(1)*

---

## 4. Mapping of Questions to Course Outcomes (CO) and Bloom Level

| Q. No. | Topic | Marks | CO | Bloom Level (BNQF cognitive) |
|---|---|---|---|---|
| Q1 | Software design, architectural vs detailed design, design outcome | 5 | CO1 | C1 Knowledge, C2 Understanding |
| Q2 | Modularity, coupling, cohesion and their types | 5 | CO2 | C1 Knowledge, C2 Understanding |
| Q3 | Abstraction, encapsulation, information hiding, CK metrics | 5 | CO2 | C1 Knowledge, C2 Understanding |
| Q4 | Software architecture and architectural styles | 5 | CO3 | C1 Knowledge, C2 Understanding |
| Q5 | Enterprise application architecture (Fowler) patterns | 5 | CO3 | C1 Knowledge, C2 Understanding |
| Q6 | GoF categories, Factory Method, Prototype, Singleton | 5 | CO4 | C1 Knowledge, C2 Understanding |
| Q7 | GoF behavioral and structural patterns (any two) | 5 | CO4 | C2 Understanding |
| Q8 | UI principles, modalities and colour guidelines | 5 | CO5 | C1 Knowledge, C2 Understanding |

### CO-wise mark distribution

| CO | Questions | Marks |
|---|---|---|
| CO1 | Q1 | 5 |
| CO2 | Q2, Q3 | 10 |
| CO3 | Q4, Q5 | 10 |
| CO4 | Q6, Q7 | 10 |
| CO5 | Q8 | 5 |
| **Total** | **8 questions** | **40** |

### Suggested time (60 minutes)

About 7 to 8 minutes per question (8 × 7.5 = 60 minutes).

---

## 5. Marking Guide (Key Points)

**Q1 (5)**
- (a) Design is a form of problem-solving; for software, the input of the design process is the requirements. (2)
- (b) Architectural design (high-level/top-level design) describes how software is organized into components; detailed design describes the desired behavior of these components. (1.5)
- (c) Outcome: a set of models and artifacts recording the major decisions taken. The rationale of each non-trivial decision is recorded to enhance long-term maintainability. (1.5)

**Q2 (5)**
- (a) Large software is divided into smaller named components with well-defined interfaces describing component interactions; different functionalities and responsibilities go into different components. (1)
- (b) Coupling: measure of interdependence among components. Cohesion: measure of the strength of association of the elements within a component. Low coupling and high cohesion give a good split, so components are easier to understand, change and maintain. (2)
- (c) Coupling, low to high: Uncoupled (no dependencies), Data, Stamp, Control, Common, Content. Cohesion, low to high: Coincidental (parts unrelated), Logical (similar functions), Temporal (related by time), Procedural (related by order of functions), Communicational (access same data), Sequential (output of one part is input to the next), Functional (all parts contribute to one complete, related function). Full marks for correct order with brief descriptions; partial marks for a partial list. (2)

**Q3 (5)**
- (a) Abstraction: a view of an object that focuses on the information relevant to a particular purpose and ignores the rest. Encapsulation and information hiding: grouping and packaging the internal details of an abstraction and making those details inaccessible to external entities (Parnas). (2)
- (b) Quality is assessed by design reviews (informal or formal) and by software metrics. Any three metrics, 1 mark each: CBO (number of classes used by a class), LCOM (lack of cohesion of methods, from method pairs that share or do not share attributes), WMC (sum of complexities of the class's methods, e.g. LOC or McCabe), RFC (number of class methods plus methods called by them), DIT (depth of the class in the inheritance tree), NOC (number of subclasses). (3)

**Q4 (5)**
- (a) Software architecture is the set of structures needed to reason about the system, comprising software elements, relations among them, and properties of both. (1)
- (b) Any three styles, 1.33 marks each:
  - Layered: components organized in layers (for example presentation, business, data); each layer depends only on the next layer.
  - Event-based: event producers and consumers; consumers register for events and an event distribution mechanism delivers them.
  - MVC: model (domain information), view (display of the model), controller (takes user input, manipulates the model and updates the view); UI is view plus controller.
  - Blackboard/repository: independent knowledge sources/components work on shared data (the blackboard).
  - Pipes and filters: filters perform computations; data flows between them through pipes (for example `ls -l | grep "Aug" | sort`).

**Q5 (5)**
- (a) Presentation: provision of services, display of information, handling user requests (mouse clicks, keyboard hits, HTTP requests, command-line invocations, batch API). Domain: logic that is the real point of the system. Data source: communication with databases, messaging systems, transaction managers, other packages. (1.5)
- (b) Domain Model: object model of the domain incorporating both behavior and data; good for complex real-world business logic. Service Layer: defines the application's boundary with a set of available operations and coordinates the response to each operation; used when different types of clients need common interactions, avoiding duplicated logic in each interface. Data Mapper (also Repository/DAO): a layer of mappers that moves data between in-memory objects and the database while keeping them independent of each other; fits well with Domain Model. (2)
- (c) Single Table: one table with columns for all fields of all classes in the hierarchy (no joins; wasted space, large table). Class Table: one table per class linked by foreign keys (easy to understand, no wasted space; needs joins to load an object). Concrete Table: one table per leaf class holding all its fields (no joins, self-contained; redundancy, and a superclass field change affects every table). (1.5)

**Q6 (5)**
- (a) A design pattern describes a problem that occurs over and over and the core of its solution, reusable many times (Alexander). GoF categories: Creational (Factory Method, Abstract Factory, Builder, Prototype, Singleton), Structural (Adapter, Bridge, Composite, Decorator, Flyweight, Facade, Proxy), Behavioral (Interpreter, Template Method, Chain of Responsibility, Command, Iterator, Mediator, Memento, Observer, State, Strategy, Visitor). (1.5)
- (b) Factory Method: lets a class defer instantiation of the objects it needs to its subclasses. Participants: Product, ConcreteProduct, Creator (declares the factory method), ConcreteCreator (overrides it to return a ConcreteProduct). Benefit (any one): avoids tight coupling between Creator and concrete products / keeps creation code in one place / new products can be added without changing Creator. (1.5)
- (c) Prototype: specify the kinds of objects to create using a prototypical instance and create new objects by copying it; liability: cloning complex objects can be tricky (shallow vs deep copy, circular dependencies). Singleton: ensure a class has only one instance with a global access point; liability: mixes object management with object behavior, and makes debugging and unit testing (mocking) difficult. (2)

**Q7 (5)** (2.5 per pattern: intent 1, participants 1, benefit and liability 0.5)

| Pattern | Intent | Participants | Benefit / Liability |
|---|---|---|---|
| Strategy | Define a family of algorithms, encapsulate each, make them interchangeable | Strategy, ConcreteStrategy, Context | New strategies without changing Context / more objects, common interface hard to define |
| Template Method | Define the skeleton of an algorithm, deferring some steps to subclasses | AbstractClass, ConcreteClass | Code reuse, common behavior factored out / subclass writers must know which operations to override |
| Adapter | Convert the interface of a class into the interface clients expect | Target, Client, Adaptee, Adapter | Adaptee used without changing existing code / extra classes and indirection |
| Composite | Compose objects into part-whole hierarchies; treat individual and composite objects uniformly | Component, Primitive (leaf), Composite, Client | Simple clients, easy to add components / design can become too general |
| Facade | Provide a unified higher-level interface to a set of subsystem interfaces | Facade, subsystem classes | Shields clients from subsystem components / can become a God class |
| Command | Encapsulate an action as an object (queue, log, undo/redo) | Command, ConcreteCommand, Client, Invoker, Receiver | Decouples invoker from receiver, easy to add commands / extra layer, more complexity |
| Decorator | Attach new behavior to objects dynamically using wrapper objects; alternative to subclassing | Component, ConcreteComponent, Decorator, ConcreteDecorator | More flexible than static inheritance, runtime add/remove / many small objects, hard to debug |
| Observer | One-to-many dependency; dependents are notified automatically when the subject's state changes | Subject, Observer, ConcreteSubject, ConcreteObserver | Minimal abstract coupling, new observers without changing Subject / unexpected notifications |

**Q8 (5)**
- (a) Any four, 0.5 mark each for name and explanation: Learnability, User familiarity, Consistency, Minimal surprise, Recoverability, User guidance, User diversity. (2)
- (b) Any three: Question-answer (single question-answer exchange), Direct manipulation (interact with objects on screen using a pointing device or touch), Menu selection (choose a command from a menu), Form fill-in (fill the fields of a form), Command language (user issues a command with parameters), Natural language (command in natural language parsed into software commands). (2)
- (c) Any two: limit the number of colours; use colour change to show a change of software status; use colour coding to support the user's task, in a thoughtful and consistent way; support users with colour blindness (vary saturation and brightness, avoid green-red combinations); do not depend on colour alone to convey important information. (1)

---

## 6. Reference

- Slide deck: *Software Design* (SoftEng-Design.pdf), based on Pfleeger, Sommerville, SWEBOK v3, R. C. Martin, GoF *Design Patterns* (1995) and M. Fowler's *Patterns of Enterprise Application Architecture*.
