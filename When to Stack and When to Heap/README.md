When to Stack and When to Heap

Name:MD Samir Tahrian  
Student ID: IT 24007

1. Introduction

Java uses different memory areas to manage variables, objects, and method execution. Two important concepts are **Stack** and **Heap**.

Understanding Stack and Heap helps us understand how Java stores data, creates objects, and executes methods.

2. What Is Stack Memory?

Stack memory is associated with method execution. Each method invocation has its own stack frame.

A stack frame conceptually contains information such as local variables, method parameters, and execution-related data.

**Examples:**
- Local variables, such as `marks`.
- Method parameters, such as `bonus`.
- Information associated with method execution.
- Local reference variables, such as `s`.

## 3. What Is Heap Memory?

Heap memory is used for objects and arrays created during program execution.

An object's instance fields are part of that object.

**Examples:**
- Objects created using `new`.
- Instance fields, such as `age` and `salary`.
- Objects of local classes, such as `Report`.

## 4. Stack vs Heap

| Stack | Heap |
|---|---|
| Associated with method execution | Stores objects and arrays |
| Contains method execution frames | Contains object data |
| Local variables are conceptually associated with frames | Instance fields belong to objects |
| Frames are created and removed as methods execute and return | Objects remain available while reachable, until they become eligible for garbage collection |
| Each active method invocation has its own frame | Objects can be referenced by multiple variables |

**Important:** This is the conceptual Java memory model. JVM optimizations may change the physical storage of some data.

## 5. Simple Memory Diagram

Consider this code:

```java
Student s = new Student();
```

Conceptually, the memory relationship looks like this:

```text
              STACK
        +------------------+
        | Reference: s     |
        |        |         |
        +--------|---------+
                 |
                 v
               HEAP
        +------------------+
        | Student Object   |
        | age = 20          |
        +------------------+
```

Here, `s` is a reference variable associated with the current method's execution. The `Student` object and its instance field `age` are on the Heap in the conceptual model.

The reference points to the object; the reference variable and the object are not the same thing.

## 6. Code 1: Student Class

```java
class Student {
    int age = 20;

    void display() {
        int marks = 85;

        System.out.println("Instance Variable (age): " + age);
        System.out.println("Local Variable (marks): " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println("Student Object Created");
        System.out.println("Object Identity Hash Code: "
                + System.identityHashCode(s));

        s.display();
    }
}
```

### Output

```text
Student Object Created
Object Identity Hash Code: 1933863327
Instance Variable (age): 20
Local Variable (marks): 85
```

*Note: The identity hash code shown is from the recorded run. It may differ when the program runs again.*

### Memory Explanation

- `new Student()` creates a Student object.
- `age` is an instance field belonging to that object.
- `s` is a local reference variable in `main()`.
- `marks` is a local variable used during `display()`.
- `display()` is method code associated with the `Student` class.
- Calling `display()` creates a method execution frame conceptually.

### Method Execution Diagram

```text
STACK
+----------------------+
| display() frame      |
| marks = 85           |
+----------------------+
| main() frame         |
| s -> Student object  |
+----------------------+

HEAP
+----------------------+
| Student object       |
| age = 20             |
+----------------------+
```

When `display()` finishes, its execution frame is removed. The Student object may remain available as long as it is reachable.

## 7. Code 2: Employee and Local Class

```java
import java.util.Scanner;

class Employee {
    int salary;

    Employee(int salary) {
        this.salary = salary;
    }

    void display(int bonus) {
        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        class Report {
            void show() {
                System.out.println("Report: Employee salary is " + salary);
            }
        }

        Report r = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: "
                + System.identityHashCode(r));

        r.show();
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        Employee e = new Employee(salary);

        System.out.println("\nEmployee Object Created");
        System.out.println("Employee Identity Hash Code: "
                + System.identityHashCode(e));

        e.display(bonus);

        System.out.println("\nMemory Concept:");
        System.out.println("Employee object -> Heap");
        System.out.println("Report object -> Heap");
        System.out.println("salary -> Instance field");
        System.out.println("bonus -> Local variable in display()");
        System.out.println("show() -> Executes in its own method frame");

        sc.close();
    }
}
```

### Output

```text
Enter salary: 20000
Enter bonus: 4000

Employee Object Created
Employee Identity Hash Code: 1826699684

Inside display() Method:
Salary (Instance Variable): 20000
Bonus (Local Variable): 4000

Report Object Created
Report Identity Hash Code: 769429195
Report: Employee salary is 20000

Memory Concept:
Employee object -> Heap
Report object -> Heap
salary -> Instance field
bonus -> Local variable in display()
show() -> Executes in its own method frame
```

*Note: The identity hash codes may differ between runs.*

### Memory Explanation

- `Employee e` is a local reference variable in `main()`.
- `new Employee(salary)` creates an Employee object on the Heap.
- `salary` is an instance field of the Employee object.
- The constructor parameter `salary` receives the input value.
- `bonus` is a parameter of `display()`.
- `Report` is a local class declared inside `display()`.
- `new Report()` creates a Report object on the Heap.
- `r` is a local reference to that Report object.
- Calling `r.show()` creates another method execution frame.

### Memory Diagram

```text
STACK
+--------------------------+
| show() execution frame   |
+--------------------------+
| display() execution frame|
| bonus = 4000             |
| r -> Report object       |
+--------------------------+
| main() execution frame   |
| e -> Employee object     |
+--------------------------+

HEAP
+--------------------------+
| Employee object          |
| salary = 20000           |
+--------------------------+

+--------------------------+
| Report object            |
| show() method code is    |
| associated with Report   |
| class                    |
+--------------------------+
```

The `Report` object can access the `Employee` object's `salary` because the local class is declared inside an instance method and can access the enclosing instance's members.

## 8. What Happens When a Method Calls Another Method?

Suppose `display()` calls `show()`.

```text
Step 1: main() starts
        |
Step 2: display() is called
        |
Step 3: show() is called
        |
Step 4: show() finishes
        |
Step 5: display() continues
        |
Step 6: display() finishes
        |
Step 7: main() continues
```

Each active method invocation has its own conceptual stack frame. When a method returns, its frame is removed, and execution resumes in the calling method.

## 9. What Is an Object Identity Hash Code?

Java provides this method:

```java
System.identityHashCode(object);
```

It returns the identity hash code of an object.

**Important points:**
- It can help distinguish objects in a demonstration.
- Different objects can theoretically have the same identity hash code.
- It does not return the actual memory address.
- Java does not provide a standard method to print the actual physical memory address of every object.

## 10. What Happens When an Object Is No Longer Used?

Consider:

```java
Student s = new Student();
s = null;
```

After `s = null`, the reference `s` no longer points to the Student object.

If no other reachable reference points to that object, it becomes eligible for garbage collection.

Garbage collection reclaims memory when the JVM determines it is appropriate. The object is not necessarily removed immediately.

## 11. Quick Revision

| Item | Conceptual Location |
|---|---|
| `age` | Inside Student object on Heap |
| `marks` | Local variable associated with a Stack frame |
| `salary` | Inside Employee object on Heap |
| `bonus` | Method parameter associated with a Stack frame |
| `s`, `e`, `r` | Local reference variables |
| `new Student()` | Creates an object on Heap |
| `new Employee()` | Creates an object on Heap |
| `new Report()` | Creates an object on Heap |
| `display()` | Method code associated with its class; invocation uses a frame |
| `show()` | Method code associated with Report; invocation uses a frame |

## 12. Conclusion

Stack and Heap play different roles in Java memory management. Stack frames are associated with method execution, while the Heap stores objects and arrays. Instance fields belong to their objects, and local variables and parameters are associated with method execution.

Understanding these concepts helps explain object creation, method calls, variable scope, and garbage collection in Java.
